package fr.pageup.demoapp.ui.viewmodels

import androidx.lifecycle.ViewModel
import fr.pageup.demoapp.R
import fr.pageup.demoapp.data.Customer

class TourViewModel : ViewModel() {

    private var _customers = mutableListOf(
        Customer(
            "Page ",
            "UP",
            "13 Rue Marguerite Yourcenar, 21000 Dijon",
            R.drawable.page_up_logo
        ),
        Customer(
            "Deliver ",
            "UP",
            "13 Rue Marguerite Yourcenar, 21000 Dijon",
            R.drawable.deliver_up_logo
        ),

        Customer(
            "Toison ",
            "d'Or",
            "Rte de Langres, 21000 Dijon",
            R.drawable.toison_logo

        ),
        Customer(
            "Carrefour Quetigny",
            "",
            "Av. de Bourgogne, 21800 Quetigny",
            R.drawable.carrefour_logo

        ),
        Customer(
            "McDonald's ",
            "",
            "10 Rue de Cracovie 21000 Dijon",
            R.drawable.mcdo_logo

        )
    )

    fun getCustomers() = _customers
}
