package com.ifs21014.dinopedia

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
@Parcelize
data class Dinosaur (
    var name : String,
    var img : Int,
    var family: String,
    var deskripsi :String,
    var karakteristik : String,
    var group: String,
    var habitat : String,
    var makanan: String,
    var ukuran :String,
    var kelemahan : String,



):Parcelable

