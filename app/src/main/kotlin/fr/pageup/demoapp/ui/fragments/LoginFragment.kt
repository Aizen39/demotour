package fr.pageup.demoapp.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import fr.pageup.demoapp.R

class LoginFragment : Fragment() {

    // Create login fragment
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val page = inflater.inflate(R.layout.fragment_login, container, false)
        val loginbtn : Button = page.findViewById(R.id.loginBtn)
        loginbtn.setOnClickListener { view: View ->
            view.findNavController()
                .navigate(R.id.loginFragment_to_tourFragment)
        }
        return page
    }
}
