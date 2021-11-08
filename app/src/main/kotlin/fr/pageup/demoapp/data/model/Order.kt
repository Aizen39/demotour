package fr.pageup.demoapp.data.model

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import kotlinx.parcelize.Parcelize

@TypeConverters(StatusConverter::class)
@Entity(tableName = "table_order")
@JsonClass(generateAdapter = true)
@Parcelize
data class Order(

        @Json(name = "id")
        @ColumnInfo(name = "ref_order")
        @PrimaryKey
        val ref: String,

    @ColumnInfo(name = "name_order")
        val product: String,

    @ColumnInfo(name = "quantity_order")
        val quantity: Int,

    @ColumnInfo(name = "id_customer_order")
        val idCustomer: Long,

    @Transient
    @ColumnInfo(name = "status")
    var status: Status = Status.UNDELIVERED
) : Parcelable {

}


