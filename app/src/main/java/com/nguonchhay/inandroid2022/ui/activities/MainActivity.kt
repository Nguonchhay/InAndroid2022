package com.nguonchhay.inandroid2022.ui.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.nguonchhay.inandroid2022.R
import com.nguonchhay.inandroid2022.databinding.ActivityMainBinding
import com.nguonchhay.inandroid2022.ui.fragments.FavoriteFragment
import com.nguonchhay.inandroid2022.ui.fragments.HomeFragment
import com.nguonchhay.inandroid2022.ui.fragments.NewsFragment

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

//        setContentView(R.layout.activity_main)
//        val btnLogin: Button = findViewById(R.id.btnLogin)
//        btnLogin.setOnClickListener {
//            val intent = Intent(this@MainActivity, LoginActivity::class.java)
//            startActivity(intent)
//        }

        val homeFragment = HomeFragment(this)
        // Set Home as default fragment
        setFragment(homeFragment)

        binding.bottomNavMain.setOnItemSelectedListener {
            when(it.itemId) {
                R.id.menuHome -> {
                    setFragment(homeFragment)
                    binding.toolbarTitle.text = "Super News"
                }
                R.id.menuNews -> {
                    setFragment(NewsFragment(supportFragmentManager, lifecycle))
                    binding.toolbarTitle.text = "News"
                }
                R.id.menuFavorite -> {
                    setFragment(FavoriteFragment())
                    binding.toolbarTitle.text = "Favorite"
                }
                R.id.menuSetting -> {
                    startActivity(Intent(this@MainActivity, Register2Activity::class.java))
                }
            }
            true
        }
    }

    private fun setFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.fragmentContainerMain, fragment)
            commit()
        }
    }
}