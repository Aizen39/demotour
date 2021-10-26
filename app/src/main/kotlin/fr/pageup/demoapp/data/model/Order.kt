package fr.pageup.demoapp.data.model

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import com.squareup.moshi.JsonQualifier
import kotlinx.parcelize.Parcelize

@Entity(tableName = "table_order")
@JsonClass(generateAdapter = true)
@Parcelize
data class Order(

        @Json(name = "id")
        @ColumnInfo(name = "ref_order")
        @PrimaryKey(autoGenerate = true)
        val ref: String,

        @ColumnInfo(name = "name_order")
        val product: String,

        @ColumnInfo(name = "quantity_order")
        val quantity: Int,

        @ColumnInfo(name = "id_customer_order")
        val idCustomer: Long,

        val status: Status = Status.UNDELIVERED
) : Parcelable {

    enum class Status {
        DELIVERED,
        UNDELIVERED
    }

}


