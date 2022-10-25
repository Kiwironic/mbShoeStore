package com.texavy.mbshoestore.entities

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Product(
    var name: String, var size: Double, var company: String, var description: String,
) : Parcelable