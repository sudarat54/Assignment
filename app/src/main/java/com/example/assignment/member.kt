package com.example.assignment

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_member.*

class member : AppCompatActivity() {
    var auth: FirebaseAuth? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_member)
        auth = FirebaseAuth.getInstance()

        val userData = auth!!.currentUser
        textView8.text = userData?.uid.toString() + " " + userData!!.email

        button6.setOnClickListener {
            auth!!.signOut()
            Toast.makeText(this, "Logout Complete", Toast.LENGTH_SHORT).show()

            val it = Intent(this,MainActivity::class.java)
            startActivity(it)
            finish()
        }
    }
}