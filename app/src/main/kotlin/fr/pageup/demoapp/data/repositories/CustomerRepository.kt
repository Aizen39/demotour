package fr.pageup.demoapp.data.repositories

import fr.pageup.demoapp.data.remote.CustomerApi
import fr.pageup.demoapp.data.remote.ServiceProvider

class CustomerRepository {

    private val api: CustomerApi = ServiceProvider.retrofit.create(CustomerApi::class.java)

    suspend fun fetch() = api.getCustomers()
}


