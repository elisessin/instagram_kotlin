package com.ssin.instagram

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.ssin.instagram.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {

    var auth : FirebaseAuth?=null
    lateinit var binding : ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        auth = FirebaseAuth.getInstance()
        binding.buttonLogin.setOnClickListener{
            signIn()
        }
        binding.buttonSigninSignup.setOnClickListener{
            signUp()
        }
    }

    private fun signUp(){
        auth?.createUserWithEmailAndPassword(binding.editTextId.text.toString(), binding.editTextPassword.text.toString())
            ?.addOnCompleteListener{
                task -> if(task.isSuccessful){
                    startMainActivity(task.result?.user)
                } else {
                    if(task.exception?.message.isNullOrEmpty()) {
                        Toast.makeText(this, task.exception?.message, Toast.LENGTH_SHORT).show()
                    } else {
                        signIn();
                    }
                }
            }
    }

    private fun signIn(){
        auth?.signInWithEmailAndPassword(binding.editTextId.text.toString(), binding.editTextPassword.text.toString())
            ?.addOnCompleteListener{
                task -> if(task.isSuccessful){
                    startMainActivity(task.result?.user)
                } else {
                    Toast.makeText(this,task.exception?.message,Toast.LENGTH_SHORT).show()
                }
            }
    }

    private fun startMainActivity(user:FirebaseUser?){
        if(user!=null){
            startActivity(Intent(this,MainActivity::class.java))
        }
    }
}