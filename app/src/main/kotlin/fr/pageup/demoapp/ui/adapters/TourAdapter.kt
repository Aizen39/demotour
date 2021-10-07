package fr.pageup.demoapp.ui.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import fr.pageup.demoapp.R
import fr.pageup.demoapp.data.Customer

class TourAdapter(private val customers: List<Customer>, private val onItemClickListener: OnItemClickListener<Customer>) :
    RecyclerView.Adapter<TourAdapter.TourViewHolder>() {

    /** create and display each element from our model there, returning the viewholder class,
     * convert data into elements of recyclerview*/
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TourViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.tour_item, parent, false)
        return TourViewHolder(view)
    }
    
    /** this method will udpate our RecyclerView with the element's customer at a position
     * in order to load in memory only the elements displayed on the screen
     */
    override fun onBindViewHolder(holder: TourViewHolder, position: Int) {
        val customer = customers[position]
        holder.setCustomer(customer)
        holder.view.setOnClickListener {
            onItemClickListener.onItemClick(customer)
        }
    }
    
    /**
     *  @return total numbers of customers of our recycleView
     */
    override fun getItemCount() = customers.size

    inner class TourViewHolder(val view: View): RecyclerView.ViewHolder(view) {
        private val logo: ImageView = view.findViewById(R.id.logo)
        private val name: TextView = view.findViewById(R.id.name)
        private val address: TextView = view.findViewById(R.id.address)
        
        fun setCustomer(customer: Customer) {
            logo.setImageResource(customer.img)
            name.text = customer.fullName()
            address.text = customer.address
        }
    } 
    
}
