package com.example.tilespekt

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.forEach
import com.google.android.material.bottomnavigation.BottomNavigationView
import android.util.Log
import android.widget.ImageView
import android.widget.PopupMenu
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.tilespekt.databinding.ActivityMainBinding
import java.lang.Exception

class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        enableEdgeToEdge()
        setContentView(binding.root)
        replaceFragment(DashboardFragment())
        binding.bottomNavigationView.setOnItemSelectedListener {
            when(it.itemId){
                R.id.dashboard -> replaceFragment(DashboardFragment())
                R.id.mapping -> replaceFragment(MappingFragment())
                R.id.history -> replaceFragment(HistoryFragment())

                else ->{

                }
            }
            true
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }



    }

    private fun replaceFragment(fragment : Fragment){
        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.main, fragment)
        fragmentTransaction.commit()
    }
}
