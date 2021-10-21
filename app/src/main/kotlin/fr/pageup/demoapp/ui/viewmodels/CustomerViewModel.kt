package fr.pageup.demoapp.ui.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import fr.pageup.demoapp.data.model.Customer
import fr.pageup.demoapp.data.repositories.CustomerRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import timber.log.Timber

class CustomerViewModel : ViewModel() {

    private val repository = CustomerRepository()

    private val _customers = MutableLiveData<List<Customer>>()
    val customers : LiveData<List<Customer>> = _customers

    fun fetchCustomers() {
        CoroutineScope(Dispatchers.IO).launch {
            try {
                val customers = repository.fetch()
                _customers.postValue(customers)
            } catch (e: Exception) {
               Timber.e(e)
            }
        }
    }
}
