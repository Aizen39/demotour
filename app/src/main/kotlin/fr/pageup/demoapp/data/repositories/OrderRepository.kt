package fr.pageup.demoapp.data.repositories

import fr.pageup.demoapp.data.model.Customer
import fr.pageup.demoapp.data.remote.OrderApi
import fr.pageup.demoapp.data.remote.ServiceProvider

class OrderRepository {
        private val api: OrderApi = ServiceProvider.retrofit.create(OrderApi::class.java)
        suspend fun fetch(idCustomer: Long?) = api.getOrders(idCustomer)
}
