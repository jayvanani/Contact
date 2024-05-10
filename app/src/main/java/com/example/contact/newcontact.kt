package com.example.contact

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.google.android.material.textfield.TextInputEditText

class newcontact : AppCompatActivity() {

    lateinit var save:Button
    lateinit var number: TextInputEditText
    lateinit var fullname:TextInputEditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_newcontact)

        save=findViewById(R.id.save)
        number=findViewById(R.id.number)
        fullname=findViewById(R.id.fullname)


        save.setOnClickListener {

            var data=MyDatabase(this)
            data.insertnewcontact(fullname.text.toString(),number.text.toString())
            var intent= Intent(this,Homepage::class.java)
//            var datacontact=MyDatabase(this)

            startActivity(intent)

        }
    }
}