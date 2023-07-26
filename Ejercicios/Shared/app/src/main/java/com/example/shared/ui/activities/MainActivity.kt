package com.example.shared.ui.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.fragment.app.Fragment
import com.example.shared.R
import com.example.shared.ui.fragments.FragmentA
import com.example.shared.ui.fragments.SettingsFragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        configView()
        setListener()
    }

    private fun setFragments(fragment: Fragment) {
        val transaction = supportFragmentManager.beginTransaction()
        //val fragment = SettingsFragment()
        transaction.replace(R.id.myViewPager2, fragment)
        transaction.addToBackStack(null)
        transaction.commit()
    }


    private fun setListener() {
        // Control sobre la opción seleccionada.
        myNavigationView.setNavigationItemSelectedListener {
            it.isChecked = true
            when (it.itemId) {
                R.id.item11 -> {
                    // Se carga el fragment en el ViewPager2.
                    setFragments(SettingsFragment())
                    // Se cierra el Drawer Layout.
                    myDrawerLayout.close()
                    true
                }
                R.id.item12 -> {
                    setFragments(FragmentA())
                    myDrawerLayout.close()
                    true
                }
                R.id.item13 -> {
                    myDrawerLayout.close()
                    true
                }
                R.id.item14 -> {
                    myDrawerLayout.close()
                    true
                }
                R.id.item21 -> {
                    Toast.makeText(
                        applicationContext,
                        getString(R.string.txtMenu21),
                        Toast.LENGTH_SHORT
                    ).show()

                    myDrawerLayout.close()
                    true
                }
                R.id.item22 -> {
                    Toast.makeText(
                        applicationContext,
                        getString(R.string.txtMenu22),
                        Toast.LENGTH_SHORT
                    ).show()
                    myDrawerLayout.close()

                    true
                }
                else -> false
            }
        }
    }
    private fun configView() {
        setSupportActionBar(myToolBar) //Cargar toolbar la barra de arriba

        val toggle = ActionBarDrawerToggle(this,
            myDrawerLayout,
            myToolBar,
            R.string.txt_open,
            R.string.txt_close
        )
        myDrawerLayout.addDrawerListener(toggle)
        toggle.syncState()
    }
}