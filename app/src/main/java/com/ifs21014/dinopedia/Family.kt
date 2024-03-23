package com.ifs21014.dinopedia

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Family(
    val imgDestination: Int,
    val nameDestination: String,
    val descDestination: String,
    val locDestination: String,
    val familyDestination: String,
    val habitat: String,
    val makanan: String,
    val ukuran: String,
    val panjang: String,
    val weak: String
) : Parcelable
