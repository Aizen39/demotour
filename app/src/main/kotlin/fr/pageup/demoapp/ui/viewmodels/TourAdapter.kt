package fr.pageup.demoapp.ui.viewmodels

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import fr.pageup.demoapp.R
import fr.pageup.demoapp.data.Customer
import fr.pageup.demoapp.databinding.FragmentLoginBinding

class TourAdapter(private val customersList: List<Customer>) :
    RecyclerView.Adapter<TourAdapter.TourViewHolder>() {


    inner class TourViewHolder(v: View) : RecyclerView.ViewHolder(v) {
        var ordersName = v.findViewById<TextView>(R.id.delivery_name)
        var ordersDescription = v.findViewById<TextView>(R.id.delivery_description)
        var ordersLogo = v.findViewById<ImageView>(R.id.delivery_logo)

    }

    /** create and display each element from our model there, returning the viewholder class,
     * convert data into elements of recyclerview*/
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TourViewHolder {
        var inflater = LayoutInflater.from(parent.context)
        var v = inflater.inflate(R.layout.fragment_detail, parent, false)
        return TourViewHolder(v)
    }

    /** this method will udpate our RecyclerView with the element's customer at a position
     * in order to load in memory only the elements displayed on the screen
     */
    override fun onBindViewHolder(holder: TourViewHolder, position: Int) {
        val customersList = customersList[position]
        holder.ordersName.text = customersList.firstname + customersList.lastname
        holder.ordersDescription.text = customersList.description
        holder.ordersLogo.setImageResource(customersList.img)
    }

    /** return the total numbers of customers of our recycleView*/
    override fun getItemCount() = customersList.size

}
