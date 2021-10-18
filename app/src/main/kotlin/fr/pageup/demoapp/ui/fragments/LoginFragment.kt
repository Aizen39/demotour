package fr.pageup.demoapp.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.findNavController
import fr.pageup.demoapp.R
import fr.pageup.demoapp.data.model.User
import fr.pageup.demoapp.data.repositories.User
import fr.pageup.demoapp.ui.viewmodels.LoginViewModel
import fr.pageup.demoapp.ui.viewmodels.TourViewModel

class LoginFragment: Fragment(){

    private val viewModel: LoginViewModel by viewModels()
    // Create login fragment
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val page = inflater.inflate(R.layout.fragment_login, container, false)
        val loginbtn : Button = page.findViewById(R.id.loginBtn)
        /*loginbtn.setOnClickListener { view: View ->
            view.findNavController()
                .navigate(R.id.loginFragment_to_tourFragment)
        }*/
        val edit_log : EditText = page.findViewById(R.id.email)
        val edit_pw : EditText = page.findViewById(R.id.password)

        if (edit_log.text == viewModel.getUser() && edit_pw.text == viewModel.getUser()){
            /*loginbtn.setOnClickListener { view: View ->
            view.findNavController()
                .navigate(R.id.loginFragment_to_tourFragment)
        }*/
        }
        return page
    }

}
