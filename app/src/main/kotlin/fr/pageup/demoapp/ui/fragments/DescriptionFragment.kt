package fr.pageup.demoapp.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import fr.pageup.demoapp.databinding.FragmentDescriptionBinding
import fr.pageup.demoapp.ui.adapters.DescriptionAdapter
import fr.pageup.demoapp.ui.viewmodels.DescriptionViewModel
import androidx.recyclerview.widget.DividerItemDecoration


class DescriptionFragment : Fragment() {

    private lateinit var binding: FragmentDescriptionBinding

    private val args: DescriptionFragmentArgs by navArgs()

    private val viewModel: DescriptionViewModel by viewModels()

    private lateinit var adapter: DescriptionAdapter


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentDescriptionBinding.inflate(inflater,container,false)
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

        val orders = viewModel.getOrders()
        adapter = DescriptionAdapter(orders)

        val recyclerView = binding.ordersRecycler
        val layoutManager = LinearLayoutManager(requireContext())
        recyclerView.layoutManager = layoutManager

        val dividerItemDecoration = DividerItemDecoration(
            requireContext(),
            layoutManager.orientation
        )
        recyclerView.addItemDecoration(dividerItemDecoration)
        recyclerView.adapter = adapter

        binding.btnOk.setOnClickListener {
            viewModel.validateOrders()
            binding.btnOk.visibility = View.GONE
        }




    }

}
