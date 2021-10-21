package fr.pageup.demoapp.data.model

import android.os.Parcelable
import com.squareup.moshi.JsonClass
import kotlinx.parcelize.Parcelize

@JsonClass(generateAdapter = true)
@Parcelize
data class Order(
    val ref: String,
    val product: String,
    val quantity: Int,
    val idCustomer: Long,
    val status: Status = Status.UNDELIVERED
) : Parcelable {

    enum class Status {
        DELIVERED,
        UNDELIVERED
    }

}


