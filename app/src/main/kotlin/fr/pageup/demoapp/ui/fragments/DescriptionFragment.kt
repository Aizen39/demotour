package fr.pageup.demoapp.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModel
import androidx.navigation.fragment.navArgs
import fr.pageup.demoapp.databinding.FragmentDescriptionBinding
import fr.pageup.demoapp.ui.adapters.TourAdapter
import fr.pageup.demoapp.ui.viewmodels.DescriptionViewModel

class DescriptionFragment : Fragment() {

    private val args: DescriptionFragmentArgs by navArgs()

    private val viewModel: DescriptionViewModel by viewModels()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val binding = FragmentDescriptionBinding.inflate(inflater,container,false)
        with(binding) {
            firstname.text = args.customer.name
            address.text = args.customer.address
            orderReference.text = args.customer.idCustomer.toString()
            zipcode.text = args.customer.zipCode
            town.text = args.customer.town
            phone.text = args.customer.phone
            idOrderText.text = viewModel.getOrder0().idOrder.toString()
            idLabelOrder.text = viewModel.getOrder0().productName
            idQuantity.text = viewModel.getOrder0().quantity.toString()
        }

        return binding.root
    }


}
