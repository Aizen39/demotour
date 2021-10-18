package fr.pageup.demoapp.ui.viewmodels

import androidx.lifecycle.ViewModel
import fr.pageup.demoapp.data.model.User
import fr.pageup.demoapp.data.repositories.User

class LoginViewModel : ViewModel() {

    private val user = User("anthony@pageup.fr","0000")

    fun getUser() = user
}
