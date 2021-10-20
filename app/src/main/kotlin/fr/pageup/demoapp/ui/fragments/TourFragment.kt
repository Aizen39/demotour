package fr.pageup.demoapp.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import fr.pageup.demoapp.R
import fr.pageup.demoapp.data.model.Customer
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
        val recycleView = view.findViewById<RecyclerView>(R.id.customer_recycler)
        recycleView.layoutManager = LinearLayoutManager(requireContext())
        recycleView.adapter = toursAdapter
    }

    override fun onItemClick(item: Customer) {
        val direction = TourFragmentDirections.tourFragmentToDescriptionFragment(item)
        findNavController().navigate(direction)
    }
}
