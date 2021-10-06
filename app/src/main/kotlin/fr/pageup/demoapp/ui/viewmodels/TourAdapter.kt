package fr.pageup.demoapp.ui.viewmodels

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import fr.pageup.demoapp.R
import fr.pageup.demoapp.data.Customer
import fr.pageup.demoapp.databinding.FragmentDetailBinding

class TourAdapter(private var c: Context, private val customersList: List<Customer>) :
    RecyclerView.Adapter<TourAdapter.TourViewHolder>() {


    inner class TourViewHolder(val v: FragmentDetailBinding) : RecyclerView.ViewHolder(v.root)

    /** create and display each element from our model there, returning the viewholder class,
     * convert data into elements of recyclerview*/
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TourViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val v = DataBindingUtil.inflate<FragmentDetailBinding>(inflater,R.layout.fragment_detail, parent, false)
        return TourViewHolder(v)
    }

    /** this method will udpate our RecyclerView with the element's customer at a position
     * in order to load in memory only the elements displayed on the screen
     */
    override fun onBindViewHolder(holder: TourViewHolder, position: Int) {
        val customersList = customersList[position]
        holder.v.isItemsList = customersList
        //load logo
        holder.v.deliveryLogo.setImageResource(customersList.img)
        holder.v.root.setOnClickListener {
            Toast.makeText(c,"${holder.v.deliveryName} is Delivery Name", Toast.LENGTH_SHORT).show()
        }
    }

    /** return the total numbers of customers of our recycleView*/
    override fun getItemCount() = customersList.size

}
