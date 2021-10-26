package fr.pageup.demoapp.data.database

import androidx.lifecycle.LiveData
import androidx.room.*
import fr.pageup.demoapp.data.model.Customer
import fr.pageup.demoapp.data.model.Order
import fr.pageup.demoapp.data.model.User




@Dao
interface CustomerDAO {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertCustomer(customer: Customer)

    @Insert
    suspend fun insertWithOrders(customer: Customer, orders: List<Order>?)

    @Update
    suspend  fun updateOrder(order: Order)

    @Query("SELECT * from table_customer WHERE id = :idCustomer")
    suspend fun getCustomer(idCustomer: Long): Customer

    @Query("DELETE FROM table_customer")
    suspend fun clear()

}
