package fr.pageup.demoapp.ui.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import fr.pageup.demoapp.R
import fr.pageup.demoapp.data.model.Customer
import fr.pageup.demoapp.databinding.TourItemBinding


class TourAdapter(private val customers: MutableList<Customer>, private val onItemClickListener: OnItemClickListener<Customer>) :
    RecyclerView.Adapter<TourAdapter.TourViewHolder>() {

    /** create and display each element from our model there, returning the viewholder class,
     * convert data into elements of recyclerview*/
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TourViewHolder {
        val binding = TourItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return TourViewHolder(binding)
    }

    /** this method will udpate our RecyclerView with the element's customer at a position
     * in order to load in memory only the elements displayed on the screen
     */
    override fun onBindViewHolder(holder: TourViewHolder, position: Int) {
        val customer = customers[position]
        holder.setCustomer(customer)
    }


    /**
     *  @return total numbers of customers of our recycleView
     */
    override fun getItemCount() = customers.size

    inner class TourViewHolder(private val binding: TourItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun setCustomer(customer: Customer) {
            with(binding){
                logo.setImageResource(R.drawable.ic_hourglass)
                name.text = customer.name
                address.text = customer.address

            }
         binding.containerInfo.setOnClickListener {
             onItemClickListener.onItemClick(customer)
         }
        }

    }
}
