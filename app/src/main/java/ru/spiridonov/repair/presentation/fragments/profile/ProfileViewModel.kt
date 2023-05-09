package ru.spiridonov.repair.presentation.fragments.profile

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import ru.spiridonov.repair.utils.SharedPref
import ru.spiridonov.repair.domain.User

class ProfileViewModel : ViewModel() {
    private val _user = MutableLiveData<User?>()
    val user: LiveData<User?>
        get() = _user

    fun logout() {
        SharedPref.clearUser()
    }

    init {
        _user.value = SharedPref.getUser()
    }
}