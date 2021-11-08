package fr.pageup.demoapp.data.repositories

import android.content.Context
import fr.pageup.demoapp.data.local.DatabaseApp
import fr.pageup.demoapp.data.model.Order
import fr.pageup.demoapp.data.remote.OrderApi
import fr.pageup.demoapp.data.remote.ServiceProvider

class OrderRepository(context: Context) {

    //web retrofit
    private val api: OrderApi = ServiceProvider.retrofit.create(OrderApi::class.java)
    //suspend fun fetch(idCustomer: Long?) = api.getOrders(idCustomer)

    //database
    private val dao = DatabaseApp.getInstance(context).orderDao

    fun getOrders(idCustomer: Long) = dao.getOrdersByIdCustomer(idCustomer)

    suspend fun updateOrders(orders: List<Order>) {
        dao.insertAll(orders)
    }

    suspend fun update(idCustomer: Long) {
        var orders = dao.getOrdersByIdCustomer(idCustomer)
        if (shouldFetch(orders)) {
            orders = api.getOrders(idCustomer)
            dao.insertAll(orders)
        }
    }

    private fun shouldFetch(orders: List<Order>) = orders.isEmpty()


}

