package com.bhongj.rc_weeks2

import android.content.SharedPreferences
import android.os.Bundle
import android.provider.ContactsContract
import androidx.appcompat.app.AppCompatActivity
import com.bhongj.rc_weeks2.databinding.ActivitySecondBinding

class SecondActivity : AppCompatActivity() {
    lateinit var binding: ActivitySecondBinding
    lateinit var sharedPreferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySecondBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.txtSecond.text = intent.getStringExtra("data")

        sharedPreferences = getSharedPreferences("test", MODE_PRIVATE)
        val age = sharedPreferences.getInt("AGE", -1)
        val name = sharedPreferences.getString("NAME", "ERROR")

        binding.actSecondTxtAge.text = age.toString()
        binding.actSecondTxtName.text = name
    }
}