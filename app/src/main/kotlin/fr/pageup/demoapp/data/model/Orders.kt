package fr.pageup.demoapp.data.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Orders(
    val idOrder : Short,
    val productName : String,
    val quantity : Short
) : Parcelable{
}


