package com.example.taskfrenzy

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.navigation.NavController
import androidx.navigation.NavDestination
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val bottomView = findViewById<BottomNavigationView>(R.id.bottom_nav)

        val navController = findNavController(R.id.container)

        navController.removeOnDestinationChangedListener { controller, destination, arguments ->
            if(destination.id == R.id.createTaskFragment) {
                bottomView.visibility = View.GONE
            } else bottomView.visibility = View.VISIBLE

//          bottomView.visibility = if(destination.id == R.id.createTaskFragment) View.GONE else View.VISIBLE
        }
        AppBarConfiguration(
            navController.graph
        )
        bottomView.setupWithNavController(navController)
    }

    override fun onStart(){
        super.onStart()
    }

    override fun onResume() {
        super.onResume()
    }

    override fun onPause() {
        super.onPause()
    }

    override fun onStop() {
        super.onStop()
    }

    override fun onDestroy() {
        super.onDestroy()
    }
}