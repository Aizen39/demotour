package fr.pageup.demoapp.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import fr.pageup.demoapp.R
import fr.pageup.demoapp.data.Customer
import fr.pageup.demoapp.ui.activities.MainActivity
import fr.pageup.demoapp.ui.viewmodels.TourAdapter

class TourFragment : Fragment(){

    //add adapter
    private lateinit var toursAdapter: TourAdapter
    private lateinit var customersData: ArrayList<Customer>


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        /**init*/
        customersData = ArrayList<Customer>()
        toursAdapter = TourAdapter(customersData)

        /** set list*/
        listOrders()
        return inflater.inflate(R.layout.fragment_tour, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val recycleView = view.findViewById<RecyclerView>(R.id.ordersRecycle)
        recycleView.layoutManager = LinearLayoutManager(requireContext())
        recycleView.adapter = toursAdapter
    }


    /** set data*/
    fun listOrders(){
        customersData.add(Customer("Page", "UP","Ordinateurs portable DELL", R.drawable.delivery_logo))
        customersData.add(Customer("Delivery ", "UP","Voiture TESLA ", R.drawable.delivery_logo))

    }



}
