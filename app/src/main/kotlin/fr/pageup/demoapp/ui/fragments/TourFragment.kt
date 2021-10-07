package fr.pageup.demoapp.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import fr.pageup.demoapp.R
import fr.pageup.demoapp.data.Customer
import fr.pageup.demoapp.ui.adapters.OnItemClickListener
import fr.pageup.demoapp.ui.adapters.TourAdapter
import fr.pageup.demoapp.ui.viewmodels.TourViewModel

class TourFragment : Fragment(), OnItemClickListener<Customer> {

    private val viewModel: TourViewModel by viewModels()

    private lateinit var toursAdapter: TourAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        toursAdapter = TourAdapter(viewModel.getCustomers(), this)
        return inflater.inflate(R.layout.fragment_tour, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val recycleView = view.findViewById<RecyclerView>(R.id.ordersRecycle)
        recycleView.layoutManager = LinearLayoutManager(requireContext())
        recycleView.adapter = toursAdapter
    }

    override fun onItemClick(item: Customer) {
        findNavController().navigate(R.id.action_demoTourListFragment_to_descriptionFragment)
    }
}
