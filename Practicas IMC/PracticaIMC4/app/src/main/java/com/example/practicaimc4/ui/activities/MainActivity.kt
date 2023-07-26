@file:Suppress("unused")

package com.example.practicaimc4.ui.activities


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.practicaimc4.R
import com.example.practicaimc4.ui.fragments.FragmentA
import com.example.practicaimc4.ui.fragments.FragmentB
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragmanet_main.*
import kotlinx.android.synthetic.main.fragment_a.*

@Suppress("PrivatePropertyName")
class MainActivity : AppCompatActivity() {

    private var isFragmentOneLoaded = false


    private fun setView(){
        showFragmentA()
    }

    private fun showFragmentA(){
        val fragment = FragmentA()

        val bundle = Bundle()
       // bundle.putString("name","David")
        fragment.arguments = bundle


        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.fragment, fragment)
        transaction.addToBackStack(null)
        transaction.commit()
        isFragmentOneLoaded = true

    }

    private fun showFragmentB(){
        val fragment = FragmentB()

        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.fragment, fragment)
        transaction.addToBackStack(null)
        transaction.commit()
        isFragmentOneLoaded = false
    }
}