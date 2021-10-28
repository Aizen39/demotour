package fr.pageup.demoapp.data.remote

import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.Moshi
import fr.pageup.demoapp.data.model.Customer
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

object ServiceProvider {

    private const val BASE_URL = "http://172.31.99.30:5000/"
    //create moshi object
    val moshi = Moshi.Builder().build()
    //create adapter

    var adapter: JsonAdapter<Customer> = moshi.adapter(Customer::class.java)

    val retrofit = Retrofit.Builder()
        .addConverterFactory(MoshiConverterFactory.create(moshi))
        .baseUrl(BASE_URL)
        .build()


}


