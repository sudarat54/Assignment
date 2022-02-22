package com.example.assignment

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    var auth: FirebaseAuth? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        auth = FirebaseAuth.getInstance()

        if (auth!!.currentUser !=null){
            val it = Intent(this,member::class.java)
            startActivity(it)
            finish()
        }

        button7.setOnClickListener {
            val it = Intent(this, login::class.java)
            startActivity(it)
        }
    }
}