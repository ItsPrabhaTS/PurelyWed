package com.example.purelywed

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.WindowInsetsControllerCompat
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupWithNavController
import com.example.purelywed.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private var _binding:ActivityMainBinding?=null
    private val binding
        get()=_binding!!

    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var navHostFragment: NavHostFragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        _binding= ActivityMainBinding.inflate(LayoutInflater.from(this))
        setContentView(binding.root)

        WindowCompat.setDecorFitsSystemWindows(window, false)

        val controller = WindowInsetsControllerCompat(window, window.decorView)
        controller.hide(WindowInsetsCompat.Type.statusBars()) // hides status bar
        controller.systemBarsBehavior =
            WindowInsetsControllerCompat.BEHAVIOR_SHOW_TRANSIENT_BARS_BY_SWIPE

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        navHostFragment = supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        val navController=navHostFragment.navController
        val toolbar: Toolbar = binding.topAppBar
        setSupportActionBar(toolbar)
        val appBarConfiguration= AppBarConfiguration(
            setOf(R.id.homeFragment),binding.main)
        toolbar.setupWithNavController(navController, appBarConfiguration)

        navController.addOnDestinationChangedListener { _,destination,_ ->
            when(destination.id){
                R.id.loading,R.id.loginFragment->{
                    binding.topAppBar.visibility= View.GONE
                }
                else->{
                    binding.topAppBar.visibility=View.VISIBLE
                }
            }
        }



    }
}