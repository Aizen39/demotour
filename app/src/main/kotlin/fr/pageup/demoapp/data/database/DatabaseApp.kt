package fr.pageup.demoapp.data.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import fr.pageup.demoapp.data.model.Customer
import fr.pageup.demoapp.data.model.Order

@Database(version = 1, entities = [Customer::class,Order::class],exportSchema = false)
abstract class DatabaseApp : RoomDatabase() {

    //connect database to dao
    abstract val databaseDAO: CustomerDAO


    companion object{
        @Volatile
        private var INSTANCE : DatabaseApp? = null

        fun get(context: Context) : DatabaseApp {

            synchronized(this) {

                // Copy the current value of INSTANCE to a local variable so Kotlin can smart cast.
                // Smart cast is only available to local variables.
                var instance = INSTANCE

                // If instance is `null` make a new database instance.
                if (instance == null) {
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        DatabaseApp::class.java,
                        "demo_tour_database"
                    )
                        // https://medium.com/androiddevelopers/understanding-migrations-with-room-f01e04b07929
                        .fallbackToDestructiveMigration()
                        .build()
                    // Assign INSTANCE to the newly created database.
                    INSTANCE = instance
                }

                // Return instance; smart cast to be non-null.
                return instance
            }
        }
    }

}
