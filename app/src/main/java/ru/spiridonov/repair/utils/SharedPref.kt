package ru.spiridonov.repair.utils

import android.content.Context
import ru.spiridonov.repair.RepairApp
import ru.spiridonov.repair.domain.User

object SharedPref {

    private val application = RepairApp.appContext

    private fun getUnnamedSharedPref(name: String, key: String): String? =
        application.getSharedPreferences(name, Context.MODE_PRIVATE).getString(key, "")

    private fun setUnnamedSharedPref(name: String, key: String, value: String) =
        application.getSharedPreferences(name, Context.MODE_PRIVATE).edit().putString(key, value)
            .apply()


    fun saveUser(user: User) {
        setUnnamedSharedPref("user_info", "uuid", user.user_id)
        setUnnamedSharedPref("user_info", "email", user.email)
        user.passwordHash?.let { setUnnamedSharedPref("user_info", "password_hash", it) }
        setUnnamedSharedPref("user_info", "username", user.username)
        setUnnamedSharedPref("user_info", "date_created", user.dateCreated)
        setUnnamedSharedPref("user_info", "access_token", user.accessToken)
    }

    fun getUser() = User(
        user_id = getUnnamedSharedPref("user_info", "uuid") ?: "",
        email = getUnnamedSharedPref("user_info", "email") ?: "",
        passwordHash = getUnnamedSharedPref("user_info", "password_hash"),
        username = getUnnamedSharedPref("user_info", "username") ?: "",
        dateCreated = getUnnamedSharedPref("user_info", "date_created") ?: "",
        accessToken = getUnnamedSharedPref("user_info", "access_token") ?: "",
    )

    fun clearUser() =
        application.getSharedPreferences("user_info", Context.MODE_PRIVATE).edit().clear().apply()

}