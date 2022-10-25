package com.texavy.mbshoestore

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.texavy.mbshoestore.databinding.FragmentProductsDetailsBinding


class ProductDetails : Fragment() {
    private val productsVM: ProductsVM by activityViewModels()

    private lateinit var binding: FragmentProductsDetailsBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentProductsDetailsBinding.inflate(inflater, container, false)
        binding.vm = productsVM
        binding.lifecycleOwner = viewLifecycleOwner
        productsVM.clearData()
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        with(binding) {
            btnCancelAdd.setOnClickListener {
                letsGoBack2ListView()
            }

            btnSaveProduct.setOnClickListener {
                if (
                    inputProductName.isValid() && inputProductSize.isValid() && inputProductCompany.isValid() && inputProductDesc.isValid()
                ) {
                    productsVM.addProduct()
                    letsGoBack2ListView()
                }
            }
        }
    }

    private fun letsGoBack2ListView() {
        findNavController().popBackStack()

    }
}