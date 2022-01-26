package com.example.comiaseokt


import android.content.Intent
import android.content.SharedPreferences
import android.os.AsyncTask
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ProgressBar
import android.widget.Toast
import androidx.core.content.ContextCompat.startActivity
import com.example.comiaseokt.databinding.ActivityLoginBinding
import java.lang.Exception
import java.security.MessageDigest
import java.security.NoSuchAlgorithmException
import java.sql.Statement

public class LoginActivity   :  AppCompatActivity (){
    // Declaring layout button, edit texts
    var UserNameStr: String? = null
    var PasswordStr:kotlin.String? = null
    var progressBar: ProgressBar? = null

    private  lateinit var binding:ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val btn_login:Button=binding.btnLogin
        val ET_Username:EditText=binding.ETUsername
        val ET_Password:EditText=binding.ETPassword
        val progressBar:ProgressBar=binding.progressBar


        progressBar.setVisibility(View.GONE)


    }

    fun Login(view: android.view.View) {
        UserNameStr = binding.ETUsername.text.toString()
        //PasswordStr = MessageDigest.getInstance("SHA-1",binding.ETPassword.text.toString()).toString()
    }

    fun salir(view: android.view.View) {
        finish()
    }


}