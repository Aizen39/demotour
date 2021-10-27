package fr.pageup.demoapp.data.database

import androidx.room.*
import fr.pageup.demoapp.data.model.Customer


@Dao
interface CustomerDAO {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertCustomer(customer: Customer)

    @Update
    suspend  fun updateCustomer(customer: Customer)

    @Query("SELECT * from table_customer WHERE idCustomer = :idCustomer")
    suspend fun getCustomer(idCustomer: Long): Customer

    @Query("DELETE FROM table_customer")
    suspend fun clear()

}
