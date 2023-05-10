package ru.spiridonov.repair.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import ru.spiridonov.repair.domain.User
import ru.spiridonov.repair.utils.SharedPref

class AccountViewModel : ViewModel() {
    private val _errorInputEmail = MutableLiveData<Boolean>()
    val errorInputEmail: LiveData<Boolean>
        get() = _errorInputEmail
    private val _errorInputPassword = MutableLiveData<Boolean>()
    val errorInputPassword: LiveData<Boolean>
        get() = _errorInputPassword
    private val _errorInputUsername = MutableLiveData<Boolean>()
    val errorInputUsername: LiveData<Boolean>
        get() = _errorInputUsername
    private val _user = MutableLiveData<User?>()
    val user: LiveData<User?>
        get() = _user
    private val _error = MutableLiveData<String?>()
    val error: LiveData<String?>
        get() = _error

    fun login(email: String, password: String) {
        if (validateInput(email, password)) {
            CoroutineScope(Dispatchers.IO).launch {
                val user = User(
                    user_id = "1",
                    email = email,
                    passwordHash = password,
                    username = "ivan",
                    dateCreated = "2021-10-10",
                    accessToken = "123"
                )
                SharedPref.saveUser(user)
                delay(1000)
                _user.postValue(user)
            }
        }
    }


    private fun validateInput(email: String, password: String, username: String = "emp"): Boolean {
        var result = true
        if (email.isBlank()) {
            _errorInputEmail.value = true
            result = false
        }
        if (password.isBlank() || password.length < 6) {
            _errorInputPassword.value = true
            result = false
        }
        if (username.isBlank() && username != "emp") {
            _errorInputUsername.value = true
            result = false
        }
        return result
    }

    fun parseStroke(input: String?) = input?.trim() ?: ""

    fun resetErrorInputEmail() {
        _errorInputEmail.value = false
    }

    fun resetErrorInputPassword() {
        _errorInputPassword.value = false
    }

    fun resetErrorInputUsername() {
        _errorInputUsername.value = false
    }
}