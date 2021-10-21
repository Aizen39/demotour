package fr.pageup.demoapp.data.remote

import fr.pageup.demoapp.data.model.Customer
import retrofit2.http.GET

interface CustomerApi {
    @GET("api/customers")
    suspend fun getCustomers() : List<Customer>
}






