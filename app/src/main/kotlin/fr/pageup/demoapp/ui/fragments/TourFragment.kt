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

class TourFragment : Fragment() {

    //add adapter
    private lateinit var toursAdapter: TourAdapter
    private lateinit var customersData: ArrayList<Customer>


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        /**init*/
        customersData = ArrayList()
        toursAdapter = TourAdapter(requireContext(),customersData)

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


    /** set data without database*/
    private fun listOrders() {
        customersData.add(
            Customer(
                "Page ",
                "UP",
                "13 Rue Marguerite Yourcenar, 21000 Dijon",
                R.drawable.page_up_logo
            )
        )
        customersData.add(
            Customer(
                "Deliver ",
                "UP",
                "13 Rue Marguerite Yourcenar, 21000 Dijon",
                R.drawable.deliver_up_logo
            )
        )
        customersData.add(
            Customer(
                "Toison ",
                "d'Or",
                "Rte de Langres, 21000 Dijon",
                R.drawable.toison_logo
            )
        )
        customersData.add(
            Customer(
                "Carrefour Quetigny",
                "",
                "Av. de Bourgogne, 21800 Quetigny",
                R.drawable.carrefour_logo
            )
        )
        customersData.add(
            Customer(
                "McDonald's ",
                "",
                "10 Rue de Cracovie 21000 Dijon",
                R.drawable.mcdo_logo
            )
        )

    }


}
