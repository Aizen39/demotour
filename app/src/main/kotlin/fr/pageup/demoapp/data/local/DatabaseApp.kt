package fr.pageup.demoapp.data.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import fr.pageup.demoapp.data.local.CustomerConverter
import fr.pageup.demoapp.data.model.Customer
import fr.pageup.demoapp.data.model.Order

@Database(version = 1, entities = [Customer::class,Order::class],exportSchema = false)
//@TypeConverters(CustomerConverter::class)
abstract class DatabaseApp : RoomDatabase() {

    //connect database to dao
    abstract val customerDao: CustomerDao
    abstract val orderDAO: OrderDAO


    companion object{
        @Volatile
        private var INSTANCE : DatabaseApp? = null

        fun getInstance(context: Context) : DatabaseApp {

            synchronized(this) {
                return INSTANCE ?: Room.databaseBuilder(
                    context.applicationContext,
                    DatabaseApp::class.java,
                    "demotour_db"
                ).build().also {
                    INSTANCE = it
                }
            }
        }
    }

}
