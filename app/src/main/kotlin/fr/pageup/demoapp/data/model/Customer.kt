package fr.pageup.demoapp.data.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

/**
 * A customer has a name, a description and an image of his package
 */
@Parcelize
data class Customer(
    val id: Long,
    val name: String,
    val address: String,
    val zipCode: String,
    val town: String,
    val phone: String) : Parcelable
