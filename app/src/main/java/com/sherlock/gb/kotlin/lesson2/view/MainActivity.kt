package com.sherlock.gb.kotlin.lesson2.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.sherlock.gb.kotlin.lesson2.R
import com.sherlock.gb.kotlin.lesson2.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, MainFragment.newInstance())
                .commitNow()
        }
    }
}