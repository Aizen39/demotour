package fr.pageup.demoapp.ui.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import fr.pageup.demoapp.data.model.Customer
import fr.pageup.demoapp.data.model.Order
import kotlinx.coroutines.launch

class TourViewModel : ViewModel() {

    private var _customers = mutableListOf(
        Customer(
            121,
            "Page UP",
            "13 marguerite yourcenar",
            "21000",
            "Dijon",
            "0667458798",

        ),
        Customer(
            122,
            "burger king",
            "6 Rue De La Glacière Zac Les Grandes Longènes",
            "21000",
            "Dijon",
            "0387564389",


        ),
        Customer(
            123,
            "mcdo",
            "8 rue souvenir français",
            "39100",
            "Dole",
            "0645875634",


        )
    )

    fun getCustomers() = _customers

    private val customers_ = MutableLiveData<Customer>()

}
