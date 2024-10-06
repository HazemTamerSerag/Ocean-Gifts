package com.example.nasaxml

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.navigation.NavigationView
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import androidx.drawerlayout.widget.DrawerLayout
import androidx.appcompat.app.AppCompatActivity
import com.example.nasaxml.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.appBarMain.toolbar)

        val drawerLayout: DrawerLayout = binding.drawerLayout
        val navView: NavigationView = binding.navView
        val navController = findNavController(R.id.nav_host_fragment_content_main)

        appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.nav_home, R.id.nav_about, R.id.nav_articles
            ), drawerLayout
        )
        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)
        navController.addOnDestinationChangedListener { _, destination, _ ->
            when (destination.id) {
                R.id.nav_about, R.id.nav_articles -> {
                    supportActionBar?.hide()
                    resourcesMenuItem?.isVisible = true // Show it when on other fragments
                }
                R.id.nav_resources -> {
                    // Hide the toolbar and menu item on the Resources fragment
                    supportActionBar?.hide()
                    resourcesMenuItem?.isVisible = false
                }
                else -> {
                    supportActionBar?.show()
                    resourcesMenuItem?.isVisible = true // Show it on other pages
                }
            }
        }
    }

    private var resourcesMenuItem: MenuItem? = null

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.main, menu)
        // Save a reference to the Resources menu item
        resourcesMenuItem = menu.findItem(R.id.action_resources)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle menu item selection
        return when (item.itemId) {
            R.id.action_resources -> {
                findNavController(R.id.nav_host_fragment_content_main).navigate(R.id.action_home_to_resources)
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.nav_host_fragment_content_main)
        return navController.navigateUp(appBarConfiguration) || super.onSupportNavigateUp()
    }
}
