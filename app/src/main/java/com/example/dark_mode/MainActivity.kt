package com.example.dark_mode

import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.AppCompatDelegate
import androidx.appcompat.widget.SwitchCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val appSettingPrefs: SharedPreferences = getSharedPreferences("appSettingPrefs", 0)
        val isNightModeOn: Boolean = appSettingPrefs.getBoolean("NightMode", false)

        val sharedPrefsEdit: SharedPreferences.Editor = appSettingPrefs.edit()

        val switchButton = findViewById<SwitchCompat>(R.id.switch1)

        if(isNightModeOn) {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
            switchButton.isChecked=true
        }
        else AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)


        switchButton.setOnCheckedChangeListener { _, _ ->
            if (switchButton.isChecked) {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
                sharedPrefsEdit.putBoolean("NightMode", true)
                sharedPrefsEdit.apply()
            }
            else {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
                sharedPrefsEdit.putBoolean("NightMode", false)
                sharedPrefsEdit.apply()
            }

        }

    }
}