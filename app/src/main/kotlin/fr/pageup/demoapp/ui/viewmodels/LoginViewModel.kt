package fr.pageup.demoapp.ui.viewmodels

import androidx.lifecycle.ViewModel
import fr.pageup.demoapp.data.model.User

class LoginViewModel : ViewModel() {

    private val user = User("1", "1")
    fun getUserEmail() =  user.email
    fun getUserPw() = user.password
}
