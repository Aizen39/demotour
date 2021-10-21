package fr.pageup.demoapp.data.network

import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.Moshi
import fr.pageup.demoapp.data.model.Customer
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET

private const val BASE_URL = " "
//create moshi object
private val moshi = Moshi.Builder().build()
//create adapter
private val adapter: JsonAdapter<Customer> = moshi.adapter(Customer::class.java)
private val customer = adapter
/**
 */
private val retrofit = Retrofit.Builder()
        .addConverterFactory(MoshiConverterFactory.create())
        .baseUrl(BASE_URL)
        .build()

interface TourApiService {
    @GET("customers")
    suspend fun getCustomers() : List<Customer>
}






