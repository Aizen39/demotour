package fr.pageup.demoapp.ui.viewmodels

import androidx.lifecycle.ViewModel
import fr.pageup.demoapp.data.model.Orders

class DescriptionViewModel: ViewModel() {

    private var _orders = mutableListOf(
        Orders(
            1,
            "Computers",
            20
        ),
        Orders(
            2,
            "Burger",
            300
        ),
        Orders(
            3,
            "Potatoe",
            100
        )

    )

    fun getOrder0() = _orders[0]

}
