package fr.pageup.demoapp.data.remote

import fr.pageup.demoapp.data.model.Customer
import fr.pageup.demoapp.data.model.Order
import retrofit2.http.GET
import retrofit2.http.Path

interface OrderApi {
    @GET("api/customers/{idCustomer}/orders")
    suspend fun getOrders(@Path("idCustomer", encoded = true) idCustomer: Long?) : List<Order>

}














