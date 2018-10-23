package com.example.android.example1

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.database.FirebaseDatabase
import kotlinx.android.synthetic.main.activity_reservation.*

class Reservation : AppCompatActivity() {

    lateinit var editText1 : EditText
    lateinit var editText2 : EditText
    lateinit var editText3 : EditText
    lateinit var editText4 : EditText
    lateinit var editText5 : EditText
    lateinit var editText6 : EditText

    lateinit var btn1 : Button
    lateinit var btn2 : Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_reservation)

        editText1 = findViewById(R.id.yourname)
        editText2 = findViewById(R.id.telefon)
        editText3 = findViewById(R.id.procedure)
        editText4 = findViewById(R.id.day)
        editText5 = findViewById(R.id.hour)
        editText6 = findViewById(R.id.notes)

        btn1 = findViewById(R.id.savebtn)


        btn1.setOnClickListener {
            saveData()
        }


    }
    private fun saveData(){
        val yourname =  editText1.text.toString().trim()
        val telefon=    editText2.text.toString().trim()
        val procedure=  editText3.text.toString().trim()
        val day=        editText4.text.toString().trim()
        val hour=       editText5.text.toString().trim()
        val notes=      editText6.text.toString().trim()

        if(yourname.isEmpty()){
            editText1.error = "Please enter you name"
            return
        }
        if(telefon.isEmpty()){
            editText2.error = "Please enter you telefon"
            return
        }
        if(procedure.isEmpty()){
            editText3.error = "Please enter procedure"
            return
        }
        if(day.isEmpty()){
            editText4.error = "Please enter you day"
            return
        }
        if(hour.isEmpty()){
            editText5.error = "Please enter you time"
            return
        }

        val myDataBase = FirebaseDatabase.getInstance().getReference("Resevations")
        val reservationId =myDataBase.push().key
        val reservation=Reservations(reservationId, yourname,telefon,procedure, day, hour, notes)
        myDataBase.child(reservationId).setValue(reservation).addOnCompleteListener {
            Toast.makeText(this,"Successfully. We waiting for you in our beauty salon", Toast.LENGTH_LONG).show()
        }
    }
}
