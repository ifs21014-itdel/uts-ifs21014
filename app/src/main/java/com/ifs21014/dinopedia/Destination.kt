package com.ifs21014.dinopedia

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Destination(
    val imgDestination: Int,
    val nameDestination: String,
    val descDestination: String,
    val locDestination: String
) : Parcelable