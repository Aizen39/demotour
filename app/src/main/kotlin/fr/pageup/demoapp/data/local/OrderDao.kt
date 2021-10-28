package fr.pageup.demoapp.data.local

import androidx.room.*
import fr.pageup.demoapp.data.model.Customer
import fr.pageup.demoapp.data.model.CustomerWithOrders
import fr.pageup.demoapp.data.model.Order

@Dao
interface OrderDao{

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(order: Order)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(order: List<Order>)

    @Query("SELECT * FROM table_customer WHERE id = :id")
    fun getOrdersByIdCustomer(id:Long) : List<CustomerWithOrders>

    @Update
    suspend  fun update(order: Order)

    @Query("SELECT * from table_order")
    fun getAll(): List<Order>

    @Query("DELETE FROM table_order")
    suspend fun clear()
}
