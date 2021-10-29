package fr.pageup.demoapp.data.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.TypeConverter
import androidx.room.TypeConverters


class StatusConverter{

    lateinit var status: Status

    //convert String to Statue
    @TypeConverter
    fun toStatus(value: String) = enumValueOf<Status>(value)

    //convert a status to String
    @TypeConverter
    fun fromStatus(value: Status) = value.name
}











