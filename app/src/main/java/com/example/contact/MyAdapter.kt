package com.example.contact

import android.annotation.SuppressLint
import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import java.lang.Exception
import kotlin.math.log

class MyAdapter(var homepage: Homepage, var datalist: ArrayList<com.example.contact.Mydataclass>) : RecyclerView.Adapter<MyAdapter.Myclass>() {

    class Myclass(itemView: View) : RecyclerView.ViewHolder(itemView) {

        lateinit var namefirst : TextView
        lateinit var txtname : TextView
        lateinit var txtnumber : TextView
        lateinit var contactclick:LinearLayout


        init {
            namefirst = itemView.findViewById(R.id.namefirst)
            txtname = itemView.findViewById(R.id.txtname)
            txtnumber = itemView.findViewById(R.id.txtnumber)
            contactclick=itemView.findViewById(R.id.contactclick)

        }
    }

    @SuppressLint("SuspiciousIndentation")
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Myclass {
     var view = LayoutInflater.from(homepage).inflate(R.layout.abc,parent,false)
        return Myclass(view)
    }

    override fun getItemCount(): Int {

        return datalist.size
    }

    override fun onBindViewHolder(holder: Myclass, position: Int) {


        holder.txtname.setText(datalist[position].name.capitalize())
        holder.txtnumber.setText(datalist[position].num)

        try {
             holder.namefirst.setText(datalist[position].name.toString().substring(0, 1).capitalize())
        }catch (ex:Exception)
        {
            Log.d("e", "$ex")
        }

        holder.contactclick.setOnClickListener {
            var intent=Intent(homepage,contactdetails::class.java)

            intent.putExtra("namefirst","${holder.namefirst.text}")
            intent.putExtra("txtname","${holder.txtname.text}")
            intent.putExtra("txtnumber","${holder.txtnumber.text}")

            homepage.startActivity(intent)

        }

    }




}
