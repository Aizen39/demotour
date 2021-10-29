package fr.pageup.demoapp.data.model

import androidx.room.Entity

@Entity(tableName = "status_table")
enum class Status(val value: String) {
    UNDELIVERED("undelivered"),
    DELIVERED("delivered")
}
