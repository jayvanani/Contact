package com.example.contact

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout

class SignUp : AppCompatActivity() {

    lateinit var login: TextView
    lateinit var signup: Button
    lateinit var fname: TextInputEditText
    lateinit var lname: TextInputEditText
    lateinit var uname: TextInputEditText
    lateinit var eml: TextInputEditText
    lateinit var pass: TextInputEditText
    lateinit var errorsignin: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)

        login = findViewById(R.id.login)
        fname = findViewById(R.id.fname)
        lname = findViewById(R.id.lname)
        uname = findViewById(R.id.uname)
        eml = findViewById(R.id.eml)
        pass = findViewById(R.id.pass)
        signup = findViewById(R.id.signup)
        errorsignin=findViewById(R.id.errorsignin)

        login.setOnClickListener {

            intent = Intent(this, LogIn::class.java)
            startActivity(intent)
            finish()
        }

        signup.setOnClickListener {

            if(fname.text!!.isNotEmpty() && lname.text!!.isNotEmpty() && eml.text!!.isNotEmpty() && uname.text!!.isNotEmpty() && pass.text!!.isNotEmpty()) {

                var data = MyDatabase(this)

                data.insertuserdata(
                    fname.text.toString(),
                    lname.text.toString(),
                    eml.text.toString(),
                    uname.text.toString(),
                    pass.text.toString()
                )

                intent = Intent(this, LogIn::class.java)
                startActivity(intent)
                finish()
            }else{
                errorsignin.setText("Please enter all information")
            }
        }


    }
}