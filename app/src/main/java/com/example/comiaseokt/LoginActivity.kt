package com.example.comiaseokt

import android.content.Intent
import android.os.AsyncTask
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.example.comiaseokt.databinding.ActivityMainBinding
import java.lang.Exception
import java.sql.Statement

class LoginActivity : AppCompatActivity() {

    private  lateinit var binding:ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

     // Getting values from button, texts and progress bar

    }

}