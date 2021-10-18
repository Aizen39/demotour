package fr.pageup.demoapp.ui.adapters

import fr.pageup.demoapp.data.Customer

interface OnItemClickListener<T> {
    fun onItemClick(item: Customer)
}
