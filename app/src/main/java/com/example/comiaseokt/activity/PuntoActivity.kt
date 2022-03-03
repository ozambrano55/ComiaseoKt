package com.example.comiaseokt.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.comiaseokt.databinding.ActivityLoginBinding
import com.example.comiaseokt.databinding.ActivityPuntoBinding

class PuntoActivity : AppCompatActivity() {
    private  lateinit var binding: ActivityPuntoBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    binding= ActivityPuntoBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }


}