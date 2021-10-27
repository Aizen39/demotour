package fr.pageup.demoapp.data.repositories

import android.content.Context
import fr.pageup.demoapp.data.database.CustomerDAO
import fr.pageup.demoapp.data.database.DatabaseApp
import fr.pageup.demoapp.data.database.OrderDAO
import fr.pageup.demoapp.data.model.Customer
import fr.pageup.demoapp.data.remote.CustomerApi
import fr.pageup.demoapp.data.remote.ServiceProvider
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class CustomerRepository(context: Context) {

    private val api: CustomerApi = ServiceProvider.retrofit.create(CustomerApi::class.java)
    suspend fun fetch() = api.getCustomers()

    //access to database
    val customerDao: CustomerDAO

    init {
        val db = DatabaseApp.getInstance(context)
        customerDao = db.customerDAO
    }

    suspend fun insert(customer: Customer){
        withContext(Dispatchers.IO){
            customerDao.insertCustomer(customer)
        }
    }


}


