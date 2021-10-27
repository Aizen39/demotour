package fr.pageup.demoapp.ui.viewmodels

import androidx.lifecycle.ViewModel
import fr.pageup.demoapp.data.model.Login

class LoginViewModel : ViewModel() {

    private val user = Login("1", "1")
    fun getUserEmail() =  user.email
    fun getUserPw() = user.password
}
