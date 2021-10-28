package fr.pageup.demoapp.data.repositories

import android.content.Context
import fr.pageup.demoapp.data.local.DatabaseApp
import fr.pageup.demoapp.data.model.Customer
import fr.pageup.demoapp.data.remote.CustomerApi
import fr.pageup.demoapp.data.remote.ServiceProvider

class CustomerRepository(context: Context) {

    //database
    private val dao = DatabaseApp.getInstance(context).customerDao

    //web retrofit
    private val api: CustomerApi = ServiceProvider.retrofit.create(CustomerApi::class.java)

    fun getCustomers() = dao.getAll()

    suspend fun update() {
        var customers = dao.getAll()
        if (shouldFetch(customers)) {
            customers = api.getCustomers()
            dao.insertAll(customers)
        }
    }

    private fun shouldFetch(customers: List<Customer>) = customers.isEmpty()
}


