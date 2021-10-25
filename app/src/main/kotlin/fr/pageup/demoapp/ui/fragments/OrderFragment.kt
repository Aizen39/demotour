package fr.pageup.demoapp.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import fr.pageup.demoapp.ui.adapters.OrderAdapter
import fr.pageup.demoapp.ui.viewmodels.OrderViewModel
import androidx.recyclerview.widget.DividerItemDecoration
import fr.pageup.demoapp.databinding.FragmentOrderBinding


class OrderFragment : Fragment() {

    private lateinit var binding: FragmentOrderBinding

    private val args: OrderFragmentArgs by navArgs()

    private val viewModel: OrderViewModel by viewModels()

    private lateinit var adapter: OrderAdapter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentOrderBinding.inflate(inflater,container,false)
        viewModel.customer = args.customer
        with(binding) {
            firstname.text = args.customer.name
            address.text = args.customer.address
            zipcode.text = args.customer.zipCode
            town.text = args.customer.town
            phone.text = args.customer.phone
        }
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        adapter = OrderAdapter(listOf())


        val recyclerView = binding.ordersRecycler
        val layoutManager = LinearLayoutManager(requireContext())
        recyclerView.layoutManager = layoutManager

        val dividerItemDecoration = DividerItemDecoration(
            requireContext(),
            layoutManager.orientation
        )
        recyclerView.addItemDecoration(dividerItemDecoration)
        recyclerView.adapter = adapter

        viewModel.fetchOrders()

        viewModel.orders.observe(viewLifecycleOwner) {
            it?.let {
                adapter.update(it)
            }
        }



        binding.btnOk.setOnClickListener {
            viewModel.validateOrders()
            binding.btnOk.visibility = View.GONE
        }
    }

}
