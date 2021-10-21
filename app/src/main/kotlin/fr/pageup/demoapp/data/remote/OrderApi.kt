package fr.pageup.demoapp.data.remote

import fr.pageup.demoapp.data.model.Order
import retrofit2.http.GET

interface OrderApi {
    @GET("api/orders")
    suspend fun gtOrders() : List<Order>
}






