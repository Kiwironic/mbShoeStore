package com.texavy.mbshoestore.entities

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class User(
    var username: String, var password: String, var Shoes: List<Product>
) : Parcelable