package com.example.android.example1

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth

class LoggedIn : AppCompatActivity() {

    var myAuth=FirebaseAuth.getInstance()
    lateinit var btn: Button
    lateinit var btn1: Button



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_logged_in)

        btn1 = findViewById(R.id.reserve)

        btn1.setOnClickListener {
            var intent: Intent = Intent(applicationContext, Reservation::class.java)
            startActivity(intent)
        }

        btn=findViewById(R.id.logout)

        btn.setOnClickListener { view ->
            Toast.makeText(this,"Loging Out...", Toast.LENGTH_LONG).show()
            signOut()
        }
        myAuth.addAuthStateListener {
            if(myAuth.currentUser==null){
                this.finish()
            }
        }
    }
    fun signOut(){
        myAuth.signOut()
    }
}
