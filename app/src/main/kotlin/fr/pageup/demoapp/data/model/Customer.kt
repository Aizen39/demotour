package fr.pageup.demoapp.data.model

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import kotlinx.parcelize.Parcelize

@Entity(tableName = "table_customer")
@JsonClass(generateAdapter = true)
@Parcelize
data class Customer(

    @PrimaryKey
    val id: Long,

    @ColumnInfo(name = "name_c")
    val name: String,

    @ColumnInfo(name = "address_c")
    val address: String,

    @ColumnInfo(name = "zip_code")
    val zipCode: String,

    @ColumnInfo(name = "town_c")
    val town: String,

    @ColumnInfo(name = "phone_c")
    val phone: String,

    //@ColumnInfo(name = "status_c")
    var status: Status = Status.UNDELIVERED
) : Parcelable {

    enum class Status {
        UNDELIVERED,
        DELIVERED
    }
}
