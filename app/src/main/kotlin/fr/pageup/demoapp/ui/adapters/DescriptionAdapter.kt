package fr.pageup.demoapp.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import fr.pageup.demoapp.R
import fr.pageup.demoapp.data.model.Order
import fr.pageup.demoapp.databinding.FragmentDescriptionBinding
import fr.pageup.demoapp.databinding.OrderItemBinding


class DescriptionAdapter(private val orders: List<Order>) :
    RecyclerView.Adapter<DescriptionAdapter.OrderViewHolder>() {

    private lateinit var btn : FragmentDescriptionBinding

    private lateinit var img : ImageView

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
