package com.example.fragments.ui.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.fragments.R
import com.example.fragments.ui.adapters.ViewPagerAdapter
import com.example.fragments.ui.fragments.FragmentA
import com.example.fragments.ui.fragments.FragmentB
import kotlinx.android.synthetic.main.activity_tab.*

class TabActivity: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tab)
        setView()
        setListener()
    }

    private fun setView(){
        val adapter = ViewPagerAdapter(supportFragmentManager)
        adapter.addFragment(FragmentA(), "hola")
        adapter.addFragment(FragmentB(), "mundo")
        viewPager.adapter = adapter
    }

    private fun setListener(){

    }
}