package fr.pageup.demoapp.data.model

import android.os.Parcelable
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import kotlinx.parcelize.Parcelize

/**
 * A customer has a name, a description and an image of his package
 */
@JsonClass(generateAdapter = true)
@Parcelize
data class Customer(
    val id: Long,
    val name: String,
    val address: String,
    val zipCode: String,
    val town: String,
    val phone: String,
    var status: Status = Status.UNDELIVERED
) : Parcelable {

    enum class Status {
        UNDELIVERED,
        DELIVERED
    }
}
