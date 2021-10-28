package fr.pageup.demoapp.data.database

import androidx.room.*
import fr.pageup.demoapp.data.model.Customer


@Dao
interface CustomerDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(customer: Customer)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(customers: List<Customer>)

    @Update
    suspend  fun update(customer: Customer)

    @Query("SELECT * from table_customer WHERE idCustomer = :idCustomer")
    suspend fun getCustomer(idCustomer: Long): Customer

    @Query("SELECT * from table_customer")
    fun getAll(): List<Customer>

    @Query("DELETE FROM table_customer")
    suspend fun clear()

}
