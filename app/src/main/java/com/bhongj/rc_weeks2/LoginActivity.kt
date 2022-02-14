package com.bhongj.rc_weeks2

import android.content.DialogInterface
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.core.widget.addTextChangedListener
import com.bhongj.rc_weeks2.databinding.ActivityLoginBinding
import kotlin.math.log

class LoginActivity : AppCompatActivity() {
    lateinit var binding: ActivityLoginBinding
    private lateinit var sharedPreferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        sharedPreferences = getSharedPreferences("test", MODE_PRIVATE)

        /* init sharedPreferences */
        val editor : SharedPreferences.Editor = sharedPreferences.edit()
        editor.putBoolean("isLogin", false)
        editor.putString("userName", "it.userName")
        editor.apply()
        /* init sharedPreferences */

        if (sharedPreferences.getBoolean("isLogin", false)) {
            val intent = Intent(this, TalkListActivity::class.java)
            intent.putExtra("userName", sharedPreferences.getString("userName", "defaultName"))
            startActivity(intent)
            finish()
        }

        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
        Toast.makeText(this, "onCreate", Toast.LENGTH_SHORT).show()

        val builder = AlertDialog.Builder(this)
        builder.setTitle("이메일 주소가 맞지 않습니다.")
        builder.setMessage("죄송합니다. 이 이메일 주소를 사용하는\n계정을 찾을 수 없습니다. 다시\n입력하시거나 새로운 계정을 등록하세요.")
        builder.setPositiveButton("새로운 계정 등록") { dialogInterface: DialogInterface, i: Int ->
            Toast.makeText(this, "새로운 계정 등록", Toast.LENGTH_SHORT).show()
        }
        builder.setNegativeButton("다시 시도하기") { dialogInterface: DialogInterface, i: Int ->
            Toast.makeText(this, "다시 시도하기", Toast.LENGTH_SHORT).show()
        }

        binding.loginBtnLogin.setOnClickListener {
            run {
                UserInfoList.forEach {
                    if(binding.loginEdtUserId.text.toString() == it.userID
                        && binding.loginEdtUserPw.text.toString() == it.userPW){
                        Toast.makeText(this, it.userName + " : Login Success", Toast.LENGTH_SHORT).show()

                        val editor : SharedPreferences.Editor = sharedPreferences.edit()
                        editor.putBoolean("isLogin", true)
                        editor.putString("userName", it.userName)
                        editor.apply()

                        val intent = Intent(this, TalkListActivity::class.java)
                        intent.putExtra("userName", it.userName)
                        startActivity(intent)
                        finish()
                        return@run
                    }
                }
                builder.show()
                Toast.makeText(this, "Login Failed", Toast.LENGTH_SHORT).show()
            }
        }

        var loginIdEnabled = false
        var loginPwEnabled = false
        binding.loginEdtUserId.addTextChangedListener {
            loginIdEnabled = binding.loginEdtUserId.text.toString().length >= 5
            binding.loginBtnLogin.isEnabled = loginPwEnabled && loginIdEnabled
        }
        binding.loginEdtUserPw.addTextChangedListener {
            loginPwEnabled = binding.loginEdtUserPw.text.toString().length >= 4
            binding.loginBtnLogin.isEnabled = loginPwEnabled && loginIdEnabled
        }
    }

    override fun onStart() {
        super.onStart()
        Toast.makeText(this, "onStart", Toast.LENGTH_SHORT).show()
    }

    override fun onResume() {
        super.onResume()
        Toast.makeText(this, "onResume", Toast.LENGTH_SHORT).show()
    }

    override fun onPause() {
        super.onPause()
        Toast.makeText(this, "onPause", Toast.LENGTH_SHORT).show()
    }

    override fun onStop() {
        super.onStop()
        Toast.makeText(this, "onStop", Toast.LENGTH_SHORT).show()
    }

    override fun onRestart() {
        super.onRestart()
        Toast.makeText(this, "onRestart", Toast.LENGTH_SHORT).show()
    }

    override fun onDestroy() {
        super.onDestroy()
        Toast.makeText(this, "onDestroy", Toast.LENGTH_SHORT).show()
    }


    //TODO : 소프트 키보드 올라올 때, 화면 위로 올라가는 방법은?
    //TODO : TextInputEditText 에서 하단 box 지우고 corner 주는 방법
    //TODO : 중간 약관에 링크 거는 방법
}