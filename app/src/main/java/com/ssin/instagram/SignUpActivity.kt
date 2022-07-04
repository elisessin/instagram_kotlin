package com.ssin.instagram

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.ssin.instagram.databinding.ActivitySignUpBinding

class SignUpActivity : AppCompatActivity() {

    lateinit var binding : ActivitySignUpBinding

    var auth : FirebaseAuth?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivitySignUpBinding.inflate(layoutInflater)
        setContentView(binding.root)

        auth = FirebaseAuth.getInstance()

        binding.buttonSignup.setOnClickListener{
            signUp()
        }
    }

    private fun signUp(){
        auth?.createUserWithEmailAndPassword(binding.editTextId.text.toString().trim(), binding.editTextPassword.text.toString().trim())
            ?.addOnCompleteListener{
                task -> if(task.isSuccessful){
                    startMainActivity(task.result?.user)
                } else {
                    if(task.exception?.message.isNullOrEmpty()) {
                        Toast.makeText(this, task.exception?.message, Toast.LENGTH_SHORT).show()
                    }
                }
            }
    }

    private fun startMainActivity(user: FirebaseUser?){
        if(user!=null){
            startActivity(Intent(this,MainActivity::class.java))
        }
    }
}