package com.example.tilespekt

import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.forEach
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {

    lateinit var bottomNav : BottomNavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Applying custom text appearance to BottomNavigationView menu items
        val bottomNavView = findViewById<BottomNavigationView>(R.id.bottomNavigationView)
        bottomNavView.menu.forEach { menuItem ->
            val menuItemView = bottomNavView.findViewById<View>(menuItem.itemId)
            menuItemView?.let {
                val label1 = menuItemView.findViewById<TextView>(R.id.history)
                val label2 = menuItemView.findViewById<TextView>(R.id.mapping)
                val label3 = menuItemView.findViewById<TextView>(R.id.dashboard)
                label1?.setTextAppearance(R.style.BottomNavTextAppearance)
                label2?.setTextAppearance(R.style.BottomNavTextAppearance)
                label3?.setTextAppearance(R.style.BottomNavTextAppearance)
            }
        }
    }
}
