package com.example.contact

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import com.google.android.material.textfield.TextInputEditText
import kotlin.math.sign

class LogIn : AppCompatActivity() {

    lateinit var signup: TextView
    lateinit var username: TextInputEditText
    lateinit var password: TextInputEditText
    lateinit var login: Button
    lateinit var error: TextView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        signup = findViewById(R.id.signup)
        username = findViewById(R.id.username)
        password = findViewById(R.id.password)
        login = findViewById(R.id.login)
        error = findViewById(R.id.error)

        signup.setOnClickListener {

            intent = Intent(this, SignUp::class.java)
            startActivity(intent)
            finish()
        }

        login.setOnClickListener {

            var data = MyDatabase(this)
            var cursor = data.selectuser(username.text.toString(), password.text.toString())

            var firstname = ""
            var lastname = ""
            var email = ""
            var username = ""

            while (cursor.moveToNext()) {
                firstname = cursor.getString(0)
                lastname = cursor.getString(1)
                email = cursor.getString(2)
                username = cursor.getString(3)
            }
                if (username.isNotEmpty()) {

                    var intent = Intent(this, Homepage::class.java)
                    intent.putExtra("firstname", firstname)
                    intent.putExtra("lastname", lastname)
                    intent.putExtra("username", username)
                    intent.putExtra("email", email)
                    startActivity(intent)
                    finish()
                } else {
                    error.setText("Username or Password invalid")
                }
    }
}
}