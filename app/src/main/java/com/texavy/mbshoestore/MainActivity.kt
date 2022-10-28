package com.texavy.mbshoestore

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import com.texavy.mbshoestore.databinding.ActivityMainBinding
import androidx.navigation.fragment.findNavController

class MainActivity : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }


    /*seems like I need to do it another way for the activity. Signatures for onCreateView
    here makes this method unsuitable for this activity
    #todo: investigate how to inflate activities in details!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = ActivityMainBinding.inflate(inflater, container, false)
        return binding.root
    }*/

    private val binding: ActivityMainBinding by lazy{
        ActivityMainBinding.inflate(layoutInflater)
    }

}

fun EditText.isValid(): Boolean {
    val isValid = text.toString().isNotBlank()
    if (isValid.not()) {
        error = context.getString(R.string.this_is_required_field)
    }
    return isValid
}