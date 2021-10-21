package fr.pageup.demoapp.data.remote

import fr.pageup.demoapp.data.model.Customer
import retrofit2.http.GET

interface CustomerService {
    @GET("api/customers")
    suspend fun getCustomers() : List<Customer>
}






