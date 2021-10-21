package fr.pageup.demoapp.ui.viewmodels

import android.text.style.UnderlineSpan
import android.widget.ImageView
import androidx.lifecycle.ViewModel
import fr.pageup.demoapp.R
import fr.pageup.demoapp.data.model.Customer
import fr.pageup.demoapp.data.model.Order
import fr.pageup.demoapp.databinding.FragmentDescriptionBinding
import fr.pageup.demoapp.databinding.OrderItemBinding

class DescriptionViewModel : ViewModel() {

    var customer: Customer? = null

    private lateinit var img : OrderItemBinding

    private var _orders = mutableListOf(
        Order(
            "AXFOP1",
            "Computers",
            20,
            121,
        ),
        Order(
            "689GH9",
            "Desktop",
            10,
            121,
        ),
        Order(
            "2NIGE9",
            "Burger",
            300,
            122,
        ),
        Order(
            "IPF890",
            "Smartphone",
            5,
            122,
        ),
        Order(
            "HIL890",
            "Potatoe",
            100,
            123
        )
    )

    fun getOrders(): List<Order> = _orders.filter { it.idCustomer == customer?.id }

    fun validateOrders() {
        customer?.status = Customer.Status.DELIVERED

    }
}
