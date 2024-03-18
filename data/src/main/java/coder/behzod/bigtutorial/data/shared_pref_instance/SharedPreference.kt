package coder.behzod.bigtutorial.data.shared_pref_instance

import android.annotation.SuppressLint
import android.content.Context
import android.content.SharedPreferences
import coder.behzod.bigtutorial.presentation.constants.SHARED_PREFERENCE_2STRING_KEY
import coder.behzod.bigtutorial.presentation.constants.SHARED_PREFERENCE_NAME
import coder.behzod.bigtutorial.presentation.constants.SHARED_PREFERENCE_STRING_KEY

class SharedPreference(private val ctx:Context) {
    val sharedPref = ctx.getSharedPreferences(SHARED_PREFERENCE_NAME,Context.MODE_PRIVATE)

    @SuppressLint("CommitPrefEdits")
    fun saveString(str: String){
        sharedPref.edit().putString(SHARED_PREFERENCE_STRING_KEY,str).apply()
    }
    fun getString():String{
        val getString = sharedPref.getString(SHARED_PREFERENCE_STRING_KEY,"")
        return getString!!
    }
    fun getSecondString():String{
        val getString = sharedPref.getString(SHARED_PREFERENCE_2STRING_KEY,"")
        return getString!!
    }
}