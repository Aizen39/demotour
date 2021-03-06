package fr.pageup.demoapp.ui.viewmodels

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import fr.pageup.demoapp.data.model.Customer
import fr.pageup.demoapp.data.model.Order
import fr.pageup.demoapp.data.model.Status
import fr.pageup.demoapp.data.repositories.OrderRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import timber.log.Timber

class OrderViewModel(context: Context) : ViewModel() {

    var customer: Customer? = null

    private val repository = OrderRepository(context)

    private val _orders = MutableLiveData<List<Order>>()
    val orders : LiveData<List<Order>> = _orders



    /*init {
        fetchOrders(OrderApiFilter.SHOW_ID)
    }*/
    fun fetchOrders(idCustomer : Long) {
        CoroutineScope(Dispatchers.IO).launch {
            try {
                repository.update(idCustomer)
                val orders = repository.getOrders(idCustomer)
                _orders.postValue(orders)
            } catch (e: Exception) {
                Timber.e(e)
            }
        }
    }
    //fun getOrders(): List<Order> = _orders.filter { it.idCustomer == customer?.id }

    fun validateOrders() {
        CoroutineScope(Dispatchers.IO).launch {
            _orders.value?.let {
                repository.updateOrders(it)
            }
        }
    }

    fun invertStatusOrder(order: Order){
        order.status = when (order.status) {
            Status.UNDELIVERED -> Status.DELIVERED
            Status.DELIVERED -> Status.UNDELIVERED
        }
    }

}
