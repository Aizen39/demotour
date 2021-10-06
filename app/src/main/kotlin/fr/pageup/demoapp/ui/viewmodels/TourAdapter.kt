package fr.pageup.demoapp.ui.viewmodels

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import fr.pageup.demoapp.R
import fr.pageup.demoapp.data.Customer
import fr.pageup.demoapp.databinding.FragmentDetailBinding
import fr.pageup.demoapp.ui.fragments.DescriptionFragment

class TourAdapter(private var c: Context, private val customersList: List<Customer>) :
    RecyclerView.Adapter<TourAdapter.TourViewHolder>() {


    inner class TourViewHolder(val v: FragmentDetailBinding) : RecyclerView.ViewHolder(v.root)

    /** create and display each element from our model there, returning the viewholder class,
     * convert data into elements of recyclerview*/
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TourViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val v = DataBindingUtil.inflate<FragmentDetailBinding>(inflater,R.layout.fragment_detail, parent, false)
        v.clickItem.setOnClickListener { view : View ->
            view.findNavController().navigate(R.id.action_demoTourListFragment_to_descriptionFragment)
        }
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
        /**var imgF :Int= fruitsLists.fruitsImg
        var fruitsIntent = Intent(c,NewActivity::class.java)*/
        var imgItem : Int = customersList.img
        var itemItem = Intent(c,DescriptionFragment::class.java)
        itemItem.putExtra("itemName",customersList.firstname)
        itemItem.putExtra("itemName",customersList.lastname)
        itemItem.putExtra("itemName",customersList.img)

    }

    /** return the total numbers of customers of our recycleView*/
    override fun getItemCount() = customersList.size

}
