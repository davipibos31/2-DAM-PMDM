package com.example.shared.ui.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.fragment.app.Fragment
import com.example.shared.R
import com.example.shared.ui.fragments.ItemPetsFragments
import com.example.shared.ui.fragments.PrincipalFragments
import com.example.shared.ui.fragments.SecondFragments
import com.example.shared.ui.fragments.SettingsFragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(myToolBar) //Cargar toolbar la barra de arriba

        val toggle = ActionBarDrawerToggle(this,
             myDrawerLayout,
            myToolBar,
             R.string.txt_open,
            R.string.txt_close
             )
        myDrawerLayout.addDrawerListener(toggle)
        toggle.syncState()

        // Control sobre la opción seleccionada.
        myNavigationView.setNavigationItemSelectedListener {
            it.isChecked = true
            when (it.itemId) {
            R.id.item11 -> {
                // Se carga el fragment en el ViewPager2.
                setFragments(PrincipalFragments())
                // Se cierra el Drawer Layout.
                myDrawerLayout.close()
                true
                }
            R.id.item12 -> {
                setFragments(SecondFragments())
                myDrawerLayout.close()
                true
                }
            R.id.item13 -> {
                setFragments(ItemPetsFragments())
                myDrawerLayout.close()
                true
            }
            R.id.item14 -> {
                setFragments(SettingsFragment())
                myDrawerLayout.close()
                true
            }
            else -> false
            }
        }
    }

    private fun setFragments(fragment: Fragment) {
        val transaction = supportFragmentManager.beginTransaction()
        //val fragment = SettingsFragment()
        transaction.replace(R.id.myViewPager2, fragment)
        transaction.addToBackStack(null)
        transaction.commit()
    }
}