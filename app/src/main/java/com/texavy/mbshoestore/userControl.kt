package com.texavy.mbshoestore

import android.app.Activity
import android.content.Context
import android.content.Context.INPUT_METHOD_SERVICE
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import androidx.core.content.ContextCompat.getSystemService
import androidx.navigation.fragment.findNavController
import com.texavy.mbshoestore.databinding.FragmentUserControlBinding
import com.texavy.mbshoestore.isValid


class userControl : Fragment() {
    private lateinit var binding: FragmentUserControlBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentUserControlBinding.inflate(inflater, container, false)
        // Inflate the layout for this fragment
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        with(binding) {
            btnLogin.setOnClickListener {
                checkValidity()

            }
            btnRegister.setOnClickListener {
                checkValidity()
            }
        }
    }

    private fun checkValidity() {
        with(binding) {
            if (etxtUserName.isValid() && etxtPassword.isValid())
                findNavController().navigate(userControlDirections.actionUserControlToSplash())
        }
        this.view?.let { hideKeyboard(it) }
    }

    private fun hideKeyboard(view: View) {
        //todo
        // Hide Keyboard view here:
        /* To show -> change it to hide
        if (view.requestFocus()) {
                val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
                imm.showSoftInput(view, InputMethodManager.SHOW_IMPLICIT)
            }
         */
    }
}