package com.yoonho.youngmin

import android.content.Context
import android.graphics.Color
import android.graphics.drawable.GradientDrawable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.res.ResourcesCompat

data class DataForList (
    val image : String,
    val text1 : String,
    val text2 : String
)
class KakaoAdapter(val li : ArrayList<DataForList>, val context : Context) : BaseAdapter() {
    override fun getCount(): Int {
        return li.size
    }

    override fun getItem(position: Int): Any {
        return  li[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getView(p0: Int, p1: View?, p2: ViewGroup?): View {
        var convertView = p1
        if (convertView == null){
            convertView = LayoutInflater.from(context).inflate(R.layout.kakao, p2,false)
            //convertView = LayoutInflater.from(p2?.context).inflate(R.layout.kakao.p2, false)
        }else{
            convertView = p1
        }
        var imageView11 =  convertView!!.findViewById<ImageView>(R.id.imageview11)
        var textView11 = convertView.findViewById<TextView>(R.id.textview11)
        var textView12 = convertView.findViewById<TextView>(R.id.textview12)
        var drawable : GradientDrawable = ResourcesCompat.getDrawable(convertView.resources, R.drawable.medal,null) as GradientDrawable
        drawable.setColor(Color.parseColor(li[p0].image))
        imageView11.setImageDrawable(drawable)
        textView11.text = li[p0].text1
        textView12.text = li[p0].text2
        return convertView
    }
}