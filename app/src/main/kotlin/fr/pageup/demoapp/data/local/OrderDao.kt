package fr.pageup.demoapp.data.local

import androidx.lifecycle.LiveData
import androidx.room.*
import fr.pageup.demoapp.data.model.CustomerWithOrders
import fr.pageup.demoapp.data.model.Order
import fr.pageup.demoapp.data.model.Status
import fr.pageup.demoapp.data.model.StatusConverter


@TypeConverters(StatusConverter::class)
@Dao
interface OrderDao{

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(order: Order)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(order: List<Order>)

    @Query("SELECT * FROM table_order WHERE id_customer_order = :id")
    fun getOrdersByIdCustomer(id:Long) : List<Order>

    @Query("SELECT * from table_order")
    fun getAll(): List<Order>

    @Query("DELETE FROM table_order")
    suspend fun clear()
}
