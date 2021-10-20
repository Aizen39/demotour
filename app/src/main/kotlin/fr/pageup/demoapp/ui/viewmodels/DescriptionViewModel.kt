package fr.pageup.demoapp.ui.viewmodels

import androidx.lifecycle.ViewModel
import fr.pageup.demoapp.data.model.Customer
import fr.pageup.demoapp.data.model.Order

class DescriptionViewModel: ViewModel() {

    private var _orders = mutableListOf(
        Order(
            "AXFOP1",
            "Computers",
            20,
            121
        ),
        Order(
            "689GH9",
            "Desktop",
            10,
            121
        ),
        Order(
            "2NIGE9",
            "Burger",
            300,
            122
        ),
        Order(
            "IPF890",
            "Smartphone",
            5,
            122
        ),
        Order(
            "HIL890",
            "Potatoe",
            100,
            123
        )
    )

    fun getOrders(): List<Order> = _orders

    fun getOrders(customer: Customer): List<Order> = _orders.filter { it.idCustomer == customer.id }

}
