package com.yoonho.youngmin

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.yoonho.youngmin.databinding.ActivityMain3Binding
import com.yoonho.youngmin.databinding.ActivityMain5Binding
import kotlin.math.pow

class MainActivity5 : AppCompatActivity() {
    lateinit var binding : ActivityMain5Binding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMain5Binding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.btn51.setOnClickListener{
            var a =  Math.pow(binding.eee.text.toString().toDouble(),binding.eee2.text.toString().toDouble())
            Toast.makeText(this,
                "${a}", Toast.LENGTH_SHORT).show()
//            if (binding.checkbox51.isChecked()){
//                Toast.makeText(this, "fdzz", Toast.LENGTH_SHORT).show()실험
//            }
        }
//        var view = LayoutInflater.from(this).inflate(R.layout.activity_main5,null,false)
//        setContentView(R.layout.activity_main5)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        binding.btn52.setOnClickListener(){
            var intent : Intent = Intent(this,MainActivity6::class.java)
            startActivity(intent)
        }
//        var eee = findViewById<EditText>(R.id.eee)
//        var eee1 = findViewById<EditText>(R.id.eee2)
//        var button = findViewById<Button>(R.id.btn_5_1)
//        ViewCompat.setOnApplyWindowInsetsListener()
    }
}