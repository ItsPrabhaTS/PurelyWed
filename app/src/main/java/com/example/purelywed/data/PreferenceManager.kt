package com.example.purelywed.data
import android.content.Context
import androidx.core.content.edit
import android.content.SharedPreferences

class PreferenceManager (private val context: Context){
    companion object{
        private const val PREFERENCE_NAME="default_preferences"
        private const val USER_LOGGED_IN="user_logged_in"
        private const val USER_EMAIL="user_email"
        private const val USER_NAME="user_name"
    }

    private val preference: SharedPreferences=context.getSharedPreferences(PREFERENCE_NAME, Context.MODE_PRIVATE)

    var isLoggedIn: Boolean
        get()=preference.getBoolean(USER_LOGGED_IN,false)
        set(value){
            preference.edit {
                putBoolean(USER_LOGGED_IN,value)
            }
        }

    var userName: String
        get()=preference.getString(USER_NAME,"User")?:"User"
        set(value)=preference.edit{
            putString(USER_EMAIL,value)
        }
    var email: String
        get()=preference.getString(USER_EMAIL,"")?:""
        set(value)=preference.edit{
            putString(USER_EMAIL,value)
        }
}