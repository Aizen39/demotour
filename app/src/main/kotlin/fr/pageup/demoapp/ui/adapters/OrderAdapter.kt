package fr.pageup.demoapp.ui.adapters

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import fr.pageup.demoapp.data.model.Customer
import fr.pageup.demoapp.data.model.Order
import fr.pageup.demoapp.databinding.OrderItemBinding


class OrderAdapter(private var orders: List<Order>) :
    RecyclerView.Adapter<OrderAdapter.OrderViewHolder>() {


    /** create and display each element from our model there, returning the viewholder class,
     * convert data into elements of recyclerview*/
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OrderViewHolder {
        val binding = OrderItemBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return OrderViewHolder(binding)
    }

    /** this method will udpate our RecyclerView with the element's customer at a position
     * in order to load in memory only the elements displayed on the screen
     */
    override fun onBindViewHolder(holder: OrderViewHolder, position: Int) {
        val order = orders[position]
        holder.bind(order)

    }

    /**
     *  @return total numbers of customers of our recycleView
     */
    override fun getItemCount() = orders.size


    fun update(orders: List<Order>) {
        this.orders = orders
        notifyDataSetChanged()
    }

    inner class OrderViewHolder(private val binding: OrderItemBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(order: Order) {

            with(binding) {
                ref.text = order.ref
                product.text = order.product
                quantity.text = order.quantity.toString()
            }
        }
    }
}
