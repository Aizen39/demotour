package fr.pageup.demoapp.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
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
        return inflater.inflate(R.layout.fragment_tour, container, false)

    }

}
