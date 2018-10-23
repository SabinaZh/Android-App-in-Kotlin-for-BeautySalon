package com.example.android.example1

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.google.firebase.auth.FirebaseAuth


class MainActivity : AppCompatActivity() {



    lateinit var btn : Button
    lateinit var btn3 : Button
    lateinit var btn4 : Button
    lateinit var btn5 : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



        btn= findViewById(R.id.button)
        btn3= findViewById(R.id.button3)
        btn4= findViewById(R.id.pricebtn)
        btn5= findViewById(R.id.contactbtn)

        btn.setOnClickListener{
            var intent:Intent= Intent(applicationContext,About::class.java)
            startActivity(intent)
        }

        btn3.setOnClickListener{
            var intent:Intent= Intent(applicationContext,Main3Activity::class.java)
            startActivity(intent)
        }
        btn4.setOnClickListener{
            var intent:Intent= Intent(applicationContext,PriceList::class.java)
            startActivity(intent)
        }
        btn5.setOnClickListener{
            var intent:Intent= Intent(applicationContext,Contacts::class.java)
            startActivity(intent)
        }

    }



}
