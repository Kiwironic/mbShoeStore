package com.texavy.mbshoestore

import android.os.Bundle
import android.view.*
import androidx.core.view.MenuProvider
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Lifecycle
import androidx.navigation.fragment.findNavController
import com.texavy.mbshoestore.databinding.FragmentProductsListBinding
import com.texavy.mbshoestore.databinding.ProductViewBinding


class ProductsList : Fragment() {

    private lateinit var binding: FragmentProductsListBinding
    private val viewModel: ProductsVM by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentProductsListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        //view menu
        requireActivity().addMenuProvider(object : MenuProvider {
            override fun onCreateMenu(menu: Menu, menuInflater: MenuInflater) {
                menuInflater.inflate(R.menu.logout, menu)
            }

            override fun onMenuItemSelected(menuItem: MenuItem): Boolean {
                return when (menuItem.itemId) {
                    R.id.userControl -> {
                        findNavController().navigate(ProductsListDirections.actionProductsListToUserControl())
                        true
                    }
                    else -> false
                }
            }
        }, viewLifecycleOwner, Lifecycle.State.RESUMED)
        with(binding) {
            viewModel.productLiveData.observe(viewLifecycleOwner){
                it?.let {
                    for (Product in it){

                        val productBinding = ProductViewBinding.inflate(LayoutInflater.from(context))
                        productBinding.apply {
                            listViewName.text = Product.name
                            listViewCompany.text = Product.company
                            listViewSize.text = Product.size.toString()
                            listViewDesc.text = Product.description
                        }
                        binding.shoelistLayout.addView(productBinding.root)

                    }
                }
            }

            btnAddShoe.setOnClickListener{
                findNavController().navigate(ProductsListDirections.actionProductsListToProductsDetails())
            }
        }

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Add menu items without overriding methods in the Activity

    }


}