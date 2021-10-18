package fr.pageup.demoapp.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import fr.pageup.demoapp.R
import fr.pageup.demoapp.data.model.Orders
import fr.pageup.demoapp.ui.adapters.TourAdapter
import fr.pageup.demoapp.ui.viewmodels.TourViewModel
import org.w3c.dom.Text

class DescriptionFragment : Fragment() {

    private val args: DescriptionFragmentArgs by navArgs()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_description, container, false)
        val nameCustomer : TextView = view.findViewById(R.id.firstname)
        val addressCustomer : TextView = view.findViewById(R.id.address)
        val idReference : TextView = view.findViewById(R.id.order_reference)
        val zipCode : TextView = view.findViewById(R.id.zipcode)
        val town : TextView = view.findViewById(R.id.town)
        val phone : TextView = view.findViewById(R.id.phone)
        /*val numberOrder: TextView = view.findViewById(R.id.idOrder)
        val labelOrder: TextView = view.findViewById(R.id.idLabelOrder)
        val quantity: TextView = view.findViewById(R.id.idQuantity)*/


        nameCustomer.text = args.customer.name
        addressCustomer.text = args.customer.address
        idReference.text = args.customer.idCustomer.toString()
        zipCode.text = args.customer.zipCode
        town.text = args.customer.town
        phone.text = args.customer.phone

        return view
    }


}
