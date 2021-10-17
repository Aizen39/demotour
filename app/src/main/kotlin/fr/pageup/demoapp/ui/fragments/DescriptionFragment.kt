package fr.pageup.demoapp.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.activity.OnBackPressedCallback
import androidx.activity.addCallback
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.NavArgs
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import fr.pageup.demoapp.R
import fr.pageup.demoapp.ui.viewmodels.TourViewModel
import org.koin.android.ext.android.get
import org.koin.androidx.viewmodel.ext.android.viewModel
import java.util.EnumSet.of
import java.util.stream.Collector.of
import java.util.stream.Stream.of

class DescriptionFragment : Fragment() {

    private val args: DescriptionFragmentArgs by navArgs()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_description, container, false)
        val nameCustomer : TextView = view.findViewById(R.id.firstname)
        val addressCustomer : TextView = view.findViewById(R.id.address)
        val idReference : TextView = view.findViewById(R.id.order_reference)
        val zipCode : TextView = view.findViewById(R.id.zipcode)
        val town : TextView = view.findViewById(R.id.town)
        nameCustomer.text = args.customer.name
        addressCustomer.text = args.customer.address
        idReference.text = args.customer.idPackage.toString()
        zipCode.text = args.customer.zipCode.toString()
        town.text = args.customer.town
        return view
    }


}
