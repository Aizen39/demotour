package fr.pageup.demoapp.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.findNavController
import fr.pageup.demoapp.R
import fr.pageup.demoapp.ui.viewmodels.LoginViewModel

class LoginFragment : Fragment() {

    private val viewModel: LoginViewModel by viewModels()

    // Create login fragment
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val v = inflater.inflate(R.layout.fragment_login, container, false)
        val loginbtn: Button = v.findViewById(R.id.loginBtn)
        val edit_email: EditText = v.findViewById(R.id.email)
        val edit_pw: EditText = v.findViewById(R.id.password)

        /*if (edit_email.text.toString() == viewModel.getUseremail() && edit_pw.text.toString() == viewModel.getUserPw()) {

        }*/

        loginbtn.setOnClickListener { view: View ->
            view.findNavController()
                .navigate(R.id.loginFragment_to_tourFragment)
        }
        return v
    }


}
