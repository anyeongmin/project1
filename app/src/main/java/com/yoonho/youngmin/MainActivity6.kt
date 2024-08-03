package com.yoonho.youngmin

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.yoonho.youngmin.databinding.ActivityMain6Binding


class MainActivity6 : AppCompatActivity() {
    lateinit var binding : ActivityMain6Binding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMain6Binding.inflate(layoutInflater)
        setContentView(binding.root)
//        setContentView(R.layout.activity_main6)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        binding.bt61.setOnClickListener {
            binding.tx61.text = ( 0..10).random().toString()
        }
    }
}