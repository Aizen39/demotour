package fr.pageup.demoapp.data.repositories

import android.content.Context
import fr.pageup.demoapp.data.local.DatabaseApp
import fr.pageup.demoapp.data.model.Customer
import fr.pageup.demoapp.data.model.Order
import fr.pageup.demoapp.data.remote.CustomerApi
import fr.pageup.demoapp.data.remote.OrderApi
import fr.pageup.demoapp.data.remote.ServiceProvider

class OrderRepository(context: Context) {

    //web retrofit
    private val api: OrderApi = ServiceProvider.retrofit.create(OrderApi::class.java)
    //suspend fun fetch(idCustomer: Long?) = api.getOrders(idCustomer)

    //database
    private val dao = DatabaseApp.getInstance(context).orderDao

    fun getOrders() = dao.getAll()

    /*fun getStatus() : Boolean {
        var order : Order.Status = Order.Status.UNDELIVERED
        if(order == Order.Status.DELIVERED){
            return true
        }
        return false
    }

    fun updateStatus() {
        if(getStatus()){
            var status = dao.getStatus()
            dao.insertStatus(status)
        }
    }*/

    suspend fun update() {
        var orders = dao.getAll()
        if (shouldFetch(orders)) {
            orders = api.getOrders(1)
            dao.insertAll(orders)
        }
    }


    private fun shouldFetch(orders: List<Order>) = orders.isEmpty()


}

