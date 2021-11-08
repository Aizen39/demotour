package fr.pageup.demoapp.data.model

import androidx.room.TypeConverter
import androidx.room.TypeConverters

@TypeConverters(StatusConverter::class)
class StatusConverter{

    //convert String to Statue
    @TypeConverter
    fun toStatus(value: String) = enumValueOf<Status>(value)

    //convert a status to String
    @TypeConverter
    fun fromStatus(value: Status) = value.name
}













