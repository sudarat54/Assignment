package com.example.assignment

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_login.*
import kotlinx.android.synthetic.main.activity_register.*

class login : AppCompatActivity() {
    var auth: FirebaseAuth? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        auth = FirebaseAuth.getInstance()

        if (auth!!.currentUser != null) {
            val it = Intent(this, member::class.java)
            startActivity(it)
            finish()
        }

        button4.setOnClickListener {
            val email = pt3.text.toString().trim()
            val pass = pt4.text.toString().trim()

            if (email.isEmpty()) {
                Toast.makeText(this, "กรุณากรอก Email", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            if (pass.isEmpty()) {
                Toast.makeText(this, "กรุณากรอก Password", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            auth!!.signInWithEmailAndPassword(email, pass).addOnCompleteListener { task ->
                if (!task.isSuccessful) {
                    if (pass.length < 8) {
                        pt2.error = "กรอกรหัสผ่านให้มากกว่า 8 ตัวอักษร"
                    }else{
                        Toast.makeText(this, "Login ล้มเหลว เนื่องจาก : "+ task.exception!!.message, Toast.LENGTH_SHORT).show()
                    }
                }else{
                    Toast.makeText(this, "Login Success!", Toast.LENGTH_SHORT).show()
                    val it = Intent(this,member::class.java)
                    startActivity(it)
                    finish()
                }
            }
        }
        button2.setOnClickListener {
            val i = Intent(this,register::class.java)
            startActivity(i)
        }

        button5.setOnClickListener {
            val i = Intent(this, MainActivity::class.java)
            startActivity(i)
        }
    }
}