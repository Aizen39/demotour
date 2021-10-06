package fr.pageup.demoapp.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import fr.pageup.demoapp.R
import fr.pageup.demoapp.databinding.FragmentListItemBinding

class LoginFragment: Fragment() {

    //Create login fragment
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        val binding = DataBindingUtil.inflate<FragmentListItemBinding>(inflater,
            R.layout.fragment_list_item,container,false)
        binding.signIn.setOnClickListener {
            view:View -> view.findNavController().navigate(R.id.action_demoTourLoginFragment_to_demoTourListFragment)
        }
        return binding.root

    }
}
