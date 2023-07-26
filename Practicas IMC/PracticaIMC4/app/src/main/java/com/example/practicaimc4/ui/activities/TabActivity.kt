package com.example.practicaimc4.ui.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.practicaimc4.ui.adapters.ViewPagerAdapter
import com.example.practicaimc4.ui.fragments.FragmentA
import com.example.practicaimc4.ui.fragments.FragmentB
import com.example.practicaimc4.R
import kotlinx.android.synthetic.main.fragmanet_main.*
import kotlinx.android.synthetic.main.fragmanet_main.view.*
import kotlinx.android.synthetic.main.fragment_b.view.*

class TabActivity: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.fragmanet_main)
        setView()
        setListener()
    }

    private fun setView(){
        val adapter = ViewPagerAdapter(supportFragmentManager)
        adapter.addFragment(FragmentA(), "Calcular")
        adapter.addFragment(FragmentB(), "Historico")
        root_layout4.viewPager.adapter = adapter
        root_layout4.tab_layout.setupWithViewPager(root_layout4.viewPager)
    }

    private fun setListener(){

    }
}