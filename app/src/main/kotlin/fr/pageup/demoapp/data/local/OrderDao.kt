package fr.pageup.demoapp.data.local

import androidx.room.*
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

    /*@Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertStatus(status:Order.Status)

    @Query("SELECT status FROM table_order")
    fun getStatus() : Order.Status*/

    @Query("SELECT * from table_order")
    fun getAll(): List<Order>

    @Query("DELETE FROM table_order")
    suspend fun clear()
}
