package fr.pageup.demoapp.data.model

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.Relation


data class CustomerWithOrders(
    @Embedded
    val customer: Customer,

    @Relation(parentColumn = "idCustomer",entityColumn = "id_customer_order")
    val orders: List<Order>
)
