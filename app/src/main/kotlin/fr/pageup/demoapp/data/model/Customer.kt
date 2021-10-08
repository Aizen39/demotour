package fr.pageup.demoapp.data

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

/**
 * A customer has a name, a description and an image of his package
 */
@Parcelize
data class Customer(
    val idPackage : Long,
    val firstname: String,
    val lastname: String,
    val address: String,
    val zipCode: Long,
    val town: String,
    val phone: Long,
) : Parcelable {

    fun fullName() = "$firstname $lastname"
}
