package fr.pageup.demoapp.ui.viewmodels

import androidx.lifecycle.ViewModel
import fr.pageup.demoapp.R
import fr.pageup.demoapp.data.Customer

class TourViewModel : ViewModel() {

    private var _customers = mutableListOf(
        Customer(
            1233939,
            "UP",
            ""
            "13 Rue Marguerite Yourcenar, 21000 Dijon",

        ),
        Customer(
            1233939,
            "UP",
            "13 Rue Marguerite Yourcenar, 21000 Dijon",

        ),

        Customer(
            1233939,
            "d'Or",
            "Rte de Langres, 21000 Dijon",


        ),
        Customer(
            1233939,
            "",
            "Av. de Bourgogne, 21800 Quetigny",


        ),
        Customer(
            1233939,
            "",
            "10 Rue de Cracovie, 21000 Dijon",

        )
    )

    fun getCustomers() = _customers
}
