package fr.pageup.demoapp.ui.viewmodels

import androidx.lifecycle.ViewModel
import fr.pageup.demoapp.R
import fr.pageup.demoapp.data.Customer

class TourViewModel : ViewModel() {

    private var _customers = mutableListOf(
        Customer(
            1233939,
            "Page",
            "UP",
            "13 Rue Marguerite Yourcenar",
            21000,
            "Dijon",
            0

        ),
        Customer(
            1233939,
            "UP",
            "Deliver UP",
            "13 Rue Marguerite Yourcenar",
            21000,
            "Dijon",
            0

        ),

        Customer(
            1233939,
            "Toison",
            "D'or",
            "13 Rue Marguerite Yourcenar",
            21000,
            "Dijon",
            0
        )
    )

    fun getCustomers() = _customers
}
