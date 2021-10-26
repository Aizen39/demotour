package fr.pageup.demoapp.data.model

import androidx.room.Embedded
import androidx.room.Relation

data class CustomerWithOrders(
    @Embedded val customer: Customer,
    @Relation(parentColumn = "idCustomer",entityColumn = "idCustomer")
    val order: List<Order>
)
