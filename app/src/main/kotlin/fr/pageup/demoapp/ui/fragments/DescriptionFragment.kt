package fr.pageup.demoapp.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import fr.pageup.demoapp.databinding.FragmentDescriptionBinding

class DescriptionFragment : Fragment() {

    private val args: DescriptionFragmentArgs by navArgs()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val binding = FragmentDescriptionBinding.inflate(inflater,container,false)
        with(binding) {
            firstname.text = args.customer.name
            address.text = args.customer.address
            orderReference.text = args.customer.idCustomer.toString()
            zipcode.text = args.customer.zipCode
            town.text = args.customer.town
            phone.text = args.customer.phone
        }
        return binding.root
    }


}
