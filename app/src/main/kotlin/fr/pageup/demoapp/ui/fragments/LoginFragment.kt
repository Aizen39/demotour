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
        return v
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val loginbtn: Button = view.findViewById(R.id.loginBtn)
        val editEmail: EditText = view.findViewById(R.id.email)
        val editPassword: EditText = view.findViewById(R.id.password)
        loginbtn.setOnClickListener { view : View ->
            val txt: String = editEmail.text.toString()
            val mdp: String = editPassword.text.toString()
            if(txt == viewModel.getUseremail() && mdp == viewModel.getUserPw()){
                view.findNavController().navigate(R.id.loginFragment_to_tourFragment)
            }
        }
    }

}
