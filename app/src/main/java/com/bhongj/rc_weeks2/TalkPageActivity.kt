package com.bhongj.rc_weeks2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.bhongj.rc_weeks2.databinding.ActivityTalkPageBinding

class TalkPageActivity : AppCompatActivity() {
    lateinit var binding : ActivityTalkPageBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTalkPageBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.tlbTalkPage)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        binding.tlbTalkPage.title = intent.getStringExtra("name")
        Toast.makeText(this, intent.getStringExtra("name"), Toast.LENGTH_SHORT).show()
        Toast.makeText(this, intent.getStringExtra("message"), Toast.LENGTH_SHORT).show()

    }

    override fun onStart() {
        super.onStart()
    }

    override fun onResume() {
        super.onResume()
    }

    override fun onPause() {
        super.onPause()
    }

    override fun onStop() {
        super.onStop()
    }

    override fun onRestart() {
        super.onRestart()
    }

    override fun onDestroy() {
        super.onDestroy()
    }
}