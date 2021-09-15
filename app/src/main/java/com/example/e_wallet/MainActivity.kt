package com.example.e_wallet

import android.graphics.Color
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.content.res.AppCompatResources
import androidx.core.content.ContextCompat
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.FragmentContainerView
import com.example.e_wallet.databinding.ActivityMainBinding
import com.example.e_wallet.presentation.DrawerLayoutInteractor


class MainActivity : AppCompatActivity(), DrawerLayoutInteractor {

    private lateinit var drawerLayout: DrawerLayout
    private var _binding: ActivityMainBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMainBinding.inflate(layoutInflater)
        drawerLayout = binding.drawerLayout
        createDrawerLayout()
        setContentView(binding.root)
    }

    private fun createDrawerLayout() {
        val toggle = createToggle(binding.navHostFragmentContentMain)
        drawerLayout.apply {
            drawerElevation = 0F
            closeDrawer(GravityCompat.START)
            setScrimColor(Color.TRANSPARENT)
            addDrawerListener(toggle)
        }
        toggle.syncState()
    }

    private fun createToggle(content: FragmentContainerView): ActionBarDrawerToggle {
        return object : ActionBarDrawerToggle(
            this,
            drawerLayout,
            null,
            R.string.navigation_drawer_open,
            R.string.navigation_drawer_close
        ) {
            override fun onDrawerSlide(drawerView: View, slideOffset: Float) {
                super.onDrawerSlide(drawerView, slideOffset)
                val slideX = drawerView.width * slideOffset
                content.background = AppCompatResources.getDrawable(
                    applicationContext,
                    R.drawable.custom_rectangle
                )
                if (slideOffset == 0F) {
                    content.setBackgroundColor(
                        ContextCompat.getColor(
                            applicationContext,
                            R.color.fragment_background
                        )
                    )
                }
                //When changing the width of the SideMenu, change the multipliers
                content.translationX = slideX / 10 * 9
                content.rotation = slideOffset * -13
                content.scaleX = 1 - slideOffset / 3
                content.scaleY = 1 - slideOffset / 3
            }
        }
    }

    override fun onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }

    override fun disableDrawerLayout() {
        if (this::drawerLayout.isInitialized) {
            drawerLayout.setDrawerLockMode(DrawerLayout.LOCK_MODE_LOCKED_CLOSED)
        }
    }

    override fun enableDrawerLayout() {
        if (this::drawerLayout.isInitialized) {
            drawerLayout.setDrawerLockMode(DrawerLayout.LOCK_MODE_UNLOCKED)
        }
    }

    override fun openDrawerLayout() {
        drawerLayout.openDrawer(GravityCompat.START)
    }

    override fun onStop() {
        drawerLayout.closeDrawer(GravityCompat.START)
        _binding = null
        super.onStop()
    }
}