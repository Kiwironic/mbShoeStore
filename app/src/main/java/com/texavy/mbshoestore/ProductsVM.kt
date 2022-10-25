package com.texavy.mbshoestore

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.texavy.mbshoestore.entities.Product

//extend ViewModel
class ProductsVM : ViewModel() {

    private val _productLiveData = MutableLiveData<List<Product>>()

    val productLiveData: LiveData<List<Product>>
        get() = _productLiveData

    private val productList = mutableListOf<Product>()

    var name: String = ""
    var size: String = ""
    var company: String = ""
    var description: String = ""

    init {
        clearData()
    }

    fun addProduct() {
        productList.add(
            Product(
                name, size.toDouble(), company, description
            )
        )
        _productLiveData.value = productList
    }

    fun clearData() {
        name = ""
        size = ""
        company = ""
        description = ""
    }

}