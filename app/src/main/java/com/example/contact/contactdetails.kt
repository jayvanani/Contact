package com.example.contact

import android.content.ActivityNotFoundException
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity


class contactdetails : AppCompatActivity() {

    lateinit var namefirst: TextView
    lateinit var txtname: TextView
    lateinit var txtnumber: TextView
    lateinit var whatsapp: ImageView
    lateinit var share: ImageView
    lateinit var call: ImageView
    lateinit var c: ImageView
    lateinit var mobile: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_contactdetails)

        namefirst = findViewById(R.id.namefirst)
        txtname = findViewById(R.id.txtname)
        txtnumber = findViewById(R.id.txtnumber)
        whatsapp = findViewById(R.id.whatsapp)
        share = findViewById(R.id.share)
        call = findViewById(R.id.call)
        c = findViewById(R.id.c)
        mobile = findViewById(R.id.Mobile)

        var nf = intent.getStringExtra("namefirst")
        var na = intent.getStringExtra("txtname")
        var nu = intent.getStringExtra("txtnumber")

        namefirst.setText(nf)
        txtname.setText(na)
        txtnumber.setText(nu)
        whatsapp.setOnClickListener {
            val phoneNumber = "${txtnumber.text}"
            val uri = Uri.parse("https://api.whatsapp.com/send?phone=$phoneNumber")
            val intent = Intent(Intent.ACTION_VIEW, uri)
            startActivity(intent)
            }


        share.setOnClickListener {
            val senddIntent: Intent = Intent().apply {
                action = Intent.ACTION_SEND
                putExtra(Intent.EXTRA_TEXT, "${txtname.text}\n${txtnumber.text}")
                type = "text/plain"
            }

            val shareeIntent = Intent.createChooser(senddIntent, null)
            startActivity(shareeIntent)

        }
        call.setOnClickListener {
            val dialIntent = Intent(Intent.ACTION_DIAL)
            dialIntent.data = Uri.parse("tel:" + "${txtnumber.text}")
            startActivity(dialIntent)

        }
        c.setOnClickListener {
            val dialIntent = Intent(Intent.ACTION_DIAL)
            dialIntent.data = Uri.parse("tel:" + "${txtnumber.text}")
            startActivity(dialIntent)
        }
        txtnumber.setOnClickListener {
            val dialIntent = Intent(Intent.ACTION_DIAL)
            dialIntent.data = Uri.parse("tel:" + "${txtnumber.text}")
            startActivity(dialIntent)
        }
        mobile.setOnClickListener {
            val dialIntent = Intent(Intent.ACTION_DIAL)
            dialIntent.data = Uri.parse("tel:" + "${txtnumber.text}")
            startActivity(dialIntent)
        }


    }
}