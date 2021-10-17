package fr.pageup.demoapp.data

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

/**
 * A customer has a name, a description and an image of his package
 */
@Parcelize
data class Customer(
    val idPackage : Short,
    val name: String,
    val address: String,
    val zipCode: String,
    val town: String,
    val phone: String,
) : Parcelable {
}
