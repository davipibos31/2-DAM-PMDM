package com.example.shared.ui.activities


import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.shared.R
import com.example.shared.ui.fragments.SettingsFragment

class SettingsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_setting)
        setFragments()
    }
    private fun setFragments() {
        val transaction = supportFragmentManager.beginTransaction()
        val fragment = SettingsFragment()
        transaction.replace(R.id.tv_name2, fragment)
        transaction.addToBackStack(null)
        transaction.commit()
    }
}