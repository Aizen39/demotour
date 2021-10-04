package fr.pageup.demoapp.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import fr.pageup.demoapp.R
import fr.pageup.demoapp.databinding.DemoTourLoginFragmentBinding

class DemoTourLoginFragment: Fragment() {

    //Create login fragment
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        val binding = DataBindingUtil.inflate<DemoTourLoginFragmentBinding>(inflater,
            R.layout.demo_tour_login_fragment,container,false)
        binding.signIn.setOnClickListener {
            view:View -> view.findNavController().navigate(R.id.action_demoTourLoginFragment_to_demoTourListFragment)
        }
        return binding.root

    }
}
