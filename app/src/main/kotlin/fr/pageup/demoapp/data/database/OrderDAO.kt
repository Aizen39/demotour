package fr.pageup.demoapp.data.database

import androidx.lifecycle.LiveData
import androidx.room.*
import fr.pageup.demoapp.data.model.Customer
import fr.pageup.demoapp.data.model.CustomerWithOrders
import fr.pageup.demoapp.data.model.Order

interface OrderDAO{

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertOrders(order: Order)

    @Query("SELECT * FROM table_customer WHERE idCustomer = :id")
    suspend fun getOrdersByIdCustomer(id:Long) : List<CustomerWithOrders>

    @Update
    suspend  fun updateOrder(order: Order)

    @Query("SELECT * from table_order WHERE id_customer_order = :id")
    suspend fun getOrder(id: Long): Order

    @Query("DELETE FROM table_order")
    suspend fun clear()
}
