package com.example.PhotoOfDay.view


import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.example.PhotoOfDay.R
import com.example.PhotoOfDay.databinding.MainActivityBinding
import com.example.PhotoOfDay.view.transitions.AnimationsActivity
import com.example.PhotoOfDay.view.viewpager.ApiActivity
import com.google.android.material.bottomnavigation.BottomNavigationView


class MainActivity : AppCompatActivity() {
    private lateinit var binding: MainActivityBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setTheme(ThemeHolder.theme)

        binding = MainActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val navView: BottomNavigationView = binding.navView

        val navController = findNavController(R.id.nav_host_fragment_activity_main)

        val appBarConfiguration = AppBarConfiguration(
            setOf(R.id.navigation_home, R.id.navigation_settings)
        )
        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)
    }

    override fun onCreateOptionsMenu(menu: Menu) : Boolean {

        menuInflater.inflate(R.menu.action_bar, menu)
        return true
    }


    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        return when (item.itemId) {
            R.id.planets -> {
                val planets = Intent(this, ApiActivity::class.java)
                startActivity(planets)

                true
            }
            R.id.animations -> {
                val animations = Intent(this, AnimationsActivity::class.java)
                startActivity(animations)

                true
            }
            else ->
                super.onOptionsItemSelected(item)
        }
    }


    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt(KEY_CURRENT_THEME, ThemeHolder.theme)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        ThemeHolder.theme = savedInstanceState.getInt(KEY_CURRENT_THEME)
    }

    companion object {
        const val KEY_CURRENT_THEME = "current_theme"
    }

    object ThemeHolder {
        var theme = R.style.IndigoTheme
    }
}