package com.yoonho.youngmin

import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.hardware.camera2.CameraExtensionSession.StillCaptureLatency
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ListView
import android.widget.SeekBar
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    lateinit var ColorString : String
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        var li = ArrayList<DataForList>()
        li.add(DataForList("#FF0000","안녕1","반가워1"))
        var et1 = findViewById<EditText>(R.id.et_1_1)
        var et2 = findViewById<EditText>(R.id.et_1_2)
        var btn = findViewById<Button>(R.id.bt_1_1)
        var listview = findViewById<ListView>(R.id.lv_1_1)
        var sb1 = findViewById<SeekBar>(R.id.sb1)
        var sb2 = findViewById<SeekBar>(R.id.sb2)
        var sb3 = findViewById<SeekBar>(R.id.sb3)
        var v = findViewById<View>(R.id.v)
        var btn_1_2 = findViewById<Button>(R.id.bt_1_2)
        var seekBarlistener = (object: SeekBar.OnSeekBarChangeListener{
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                var red = String.format("%02X",sb1.progress)
                var green = String.format("%02X",sb2.progress)
                var blue = String.format("%02X",sb3.progress)
                ColorString = "#${red}${green}${blue}"
                v.setBackgroundColor(Color.parseColor(ColorString))
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {

            }

            override fun onStopTrackingTouch(seekBar: SeekBar?) {

            }

        })
        sb1.setOnSeekBarChangeListener(seekBarlistener)
        sb2.setOnSeekBarChangeListener(seekBarlistener)
        sb3.setOnSeekBarChangeListener(seekBarlistener)
        listview.adapter = KakaoAdapter(li,this)
        listview.setOnItemClickListener { parent, view, position, id ->
            val listdata = parent.getItemAtPosition(position) as DataForList
            Toast.makeText(this,listdata.text1,Toast.LENGTH_SHORT).show()
            AlertDialog.Builder(this).setTitle("${position} del")
                .setMessage("${listdata.text1} del").setIcon(R.mipmap.ic_launcher_round)
                .setPositiveButton("yes"){dialogInterface, i->
                    li.removeAt(position)
                    (listview.adapter as KakaoAdapter).notifyDataSetChanged()
                }.setNegativeButton("no",null).show()
//            val listdata = parent?.getItemAtPosition(position) as DataForList
//            Toast.makeText(this,listdata.text1,Toast.LENGTH_SHORT).show()

        }
        btn.setOnClickListener(){


            li.add(DataForList(ColorString,et1.text.toString(),et2.text.toString()))
            (listview.adapter as KakaoAdapter).notifyDataSetChanged()

        }
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        btn_1_2.setOnClickListener(){
            var intent: Intent = Intent(this, MainActivity5::class.java)
            startActivity(intent)
        }
    }
}