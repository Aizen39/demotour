package fr.pageup.demoapp.data

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

/**
 * A customer has a name, a description and an image of his package
 */
@Parcelize
data class Customer(
    val firstname: String,
    val lastname: String,
    val address: String,
    val img: Int,
    val phoneNumber: Int = 0,
    val comment: String = ""
) : Parcelable {

    fun fullName() = "$firstname $lastname"
}
