package com.example.android.example1

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.android.example1.R.id.register
import com.google.android.gms.tasks.OnCompleteListener
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_main3.*

class Main3Activity : AppCompatActivity() {

    lateinit var btn: Button

    var myAuth = FirebaseAuth.getInstance()
    lateinit var editText1:EditText
    lateinit var editText2:EditText
    lateinit var btn2:Button
    lateinit var btn3:Button



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main3)

        btn = findViewById(R.id.button4)

        btn.setOnClickListener {
            var intent: Intent = Intent(applicationContext, MainActivity::class.java)
            startActivity(intent)
        }

        editText1=findViewById(R.id.email)
        editText2=findViewById(R.id.password)
        btn2=findViewById(R.id.register)

        btn3=findViewById(R.id.login)

        btn2.setOnClickListener {

            val email=editText1.text.toString()
            val password=editText2.text.toString().trim()

            if(email.isEmpty()){
                Toast.makeText(this,"Please enter your email", Toast.LENGTH_LONG).show()
                return@setOnClickListener
            }
            if(password.isEmpty()){
                Toast.makeText(this,"Please enter your password", Toast.LENGTH_LONG).show()
                return@setOnClickListener
            }
            signUp( email,password)
        }

        btn3.setOnClickListener {
            view ->
            val email=editText1.text.toString()
            val password=editText2.text.toString().trim()
            signIn(view,email,password) }

    }

    private fun signIn(view: View, email:String, password:String){
        Toast.makeText(this, "Authenticating...", Toast.LENGTH_LONG).show()
        myAuth.signInWithEmailAndPassword(email,password).addOnCompleteListener(this, OnCompleteListener { task->
            if(task.isSuccessful){
                var intent=Intent(this, LoggedIn::class.java)
                intent.putExtra("id",myAuth.currentUser?.email)
                startActivity(intent)
            }else{
                Toast.makeText(this, "Sorry,error"+task.exception?.message, Toast.LENGTH_LONG).show()
            }
        })
    }

    private fun signUp(email:String, password:String){
    myAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(this, OnCompleteListener { task->
            if(task.isSuccessful){
      Toast.makeText(this, "Done successfully!!!", Toast.LENGTH_LONG).show()
            }else{
      Toast.makeText(this, "Sorry,error"+task.exception?.message, Toast.LENGTH_LONG).show()
            }
        })
    }
}
