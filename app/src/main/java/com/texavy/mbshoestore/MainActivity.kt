package com.texavy.mbshoestore

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import com.texavy.mbshoestore.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}

fun EditText.isValid(): Boolean {
    val isValid = text.toString().isNotBlank()
    if (isValid.not()) {
        error = context.getString(R.string.this_is_required_field)
    }
    return isValid
}