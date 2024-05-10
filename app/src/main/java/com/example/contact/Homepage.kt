package com.example.contact

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton

class Homepage : AppCompatActivity() {

    lateinit var recycle :RecyclerView
    lateinit var save:FloatingActionButton
    var datalist= arrayListOf<Mydataclass>()


    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_homepage)

        recycle=findViewById(R.id.recycle)
        save=findViewById(R.id.save)

        var data=MyDatabase(this)
        datalist.clear()
        var cursornamenumber=data.selectname()
        while (cursornamenumber.moveToNext())
        {

            var obj = Mydataclass(cursornamenumber.getString(0),cursornamenumber.getString(1))
            datalist.add(obj)

        }

        datalist.sortBy { it.name }

        var adapter = MyAdapter(this,datalist)
        recycle.adapter = adapter


        save.setOnClickListener {

            var intent=Intent(this,newcontact::class.java)
            startActivity(intent)


        }



    }
}



