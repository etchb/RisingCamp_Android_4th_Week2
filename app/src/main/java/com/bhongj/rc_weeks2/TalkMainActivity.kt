package com.bhongj.rc_weeks2

import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import androidx.navigation.fragment.NavHostFragment
import com.bhongj.rc_weeks2.databinding.ActivityTalkMainBinding

class TalkMainActivity : AppCompatActivity() {
    lateinit var binding : ActivityTalkMainBinding
    private lateinit var sharedPreferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTalkMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.tlbTalkList)

        binding.bottomNav.itemIconTintList = null
//        binding.tlbTalkList.backgroundTintList = null

        initNavigationBar()
    }

    private fun initNavigationBar() {
        binding.bottomNav.run {
            setOnItemSelectedListener {
                when(it.itemId) {
                    R.id.bttmenu_friend -> { 
                        changeFragment(TalkFriendFragment())
                        binding.tlbTalkList.title = "친구"
                    }
                    R.id.bttmenu_talk_list -> { 
                        changeFragment(TalkListFragment())
                        binding.tlbTalkList.title = "채팅"
                    }
                    R.id.bttmenu_view_page -> {
                        changeFragment(TalkViewFragment())
                        binding.tlbTalkList.title = "View"
                    }
                    R.id.bttmenu_shop_page -> {
                        changeFragment(TalkShopFragment())
                        binding.tlbTalkList.title = "Shop"
                    }
                    R.id.bttmenu_setting -> {
                        changeFragment(TalkSettingFragment())
                        binding.tlbTalkList.title = "Setting"
                        /* init sharedPreferences */
                        sharedPreferences = getSharedPreferences("test", MODE_PRIVATE)
                        val editor : SharedPreferences.Editor = sharedPreferences.edit()
                        editor.putBoolean("isAutoLogin", false)
                        editor.putString("userName", "defaultUserName")
                        editor.apply()
                        Toast.makeText(context, "init sharedPreferences", Toast.LENGTH_SHORT).show()
                        /* init sharedPreferences */
                    }
                }
                true
            }
            selectedItemId = R.id.bttmenu_talk_list
        }
    }

    override fun onResume() {
        super.onResume()
    }

    private fun changeFragment(fragment: Fragment) {
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.frmlay_talk_main, fragment) .commit() }

//    override fun onNavigationItemSelected(p0: MenuItem): Boolean {
//        val tb: Toolbar = findViewById(R.id.tlblay_talk_list)
//        tb.visibility = View.VISIBLE
//        val transaction: FragmentTransaction = supportFragmentManager.beginTransaction()
//
//        when(p0.itemId){
//            R.id.bttmenu_friend ->{
//                val fragmentA = TalkFriendFragment()
//                transaction.replace(R.id.frmlay_talk_main,fragmentA, "fragmentA")
//            }
//            R.id.bttmenu_talk_list -> {
//                val fragmentB = TalkListFragment()
//                transaction.replace(R.id.frmlay_talk_main,fragmentB, "fragmentB")
//            }
//            R.id.bttmenu_view_page -> {
//                val fragmentC = TalkFriendFragment()
//                transaction.replace(R.id.frmlay_talk_main,fragmentC, "fragmentC")
//            }
//            R.id.bttmenu_shop_page -> {
//                val fragmentD = TalkListFragment()
//                transaction.replace(R.id.frmlay_talk_main,fragmentD, "fragmentD")
//            }
//            R.id.bttmenu_setting -> {
//                val fragmentE = TalkFriendFragment()
//                transaction.replace(R.id.frmlay_talk_main,fragmentE, "fragmentE")
//                tb.visibility = View.GONE
//            }
//        }
//        transaction.addToBackStack(null)
//        transaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
//        transaction.commit()
//        return true
//    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        return super.onCreateOptionsMenu(menu)
    }
}
