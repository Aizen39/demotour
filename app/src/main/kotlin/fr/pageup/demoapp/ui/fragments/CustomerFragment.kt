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
import fr.pageup.demoapp.databinding.FragmentCustomerBinding
import fr.pageup.demoapp.ui.adapters.CustomerAdapter
import fr.pageup.demoapp.ui.adapters.OnItemClickListener
import fr.pageup.demoapp.ui.viewmodels.CustomerViewModel

class CustomerFragment : Fragment(), OnItemClickListener<Customer> {

    private val viewModel: CustomerViewModel by viewModels()
    private lateinit var binding: FragmentCustomerBinding

    private lateinit var adapter: CustomerAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentCustomerBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        adapter = CustomerAdapter(listOf(), this)

        with(binding) {
            customerRecycler.layoutManager = LinearLayoutManager(requireContext())
            customerRecycler.adapter = adapter
        }

        viewModel.fetchCustomers()

        viewModel.customers.observe(viewLifecycleOwner) {
            it?.let {
                adapter.update(it)
            }
        }

    }

    override fun onItemClick(item: Customer) {
        val direction = CustomerFragmentDirections.customerFragmentToDescriptionFragment(item)
        findNavController().navigate(direction)
    }
}
