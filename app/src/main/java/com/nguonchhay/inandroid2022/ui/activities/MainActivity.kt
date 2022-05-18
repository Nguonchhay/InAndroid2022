package com.nguonchhay.inandroid2022.ui.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import com.nguonchhay.inandroid2022.R
import com.nguonchhay.inandroid2022.data_class.NewsKtor
import com.nguonchhay.inandroid2022.databinding.ActivityMainBinding
import com.nguonchhay.inandroid2022.networks.apis.NewsApiInterface
import com.nguonchhay.inandroid2022.ui.composes.CalculatorComposeActivity
import com.nguonchhay.inandroid2022.ui.fragments.FavoriteFragment
import com.nguonchhay.inandroid2022.ui.fragments.HomeFragment
import com.nguonchhay.inandroid2022.ui.fragments.NewsFragment
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    lateinit var newApi: NewsApiInterface

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        newApi = NewsApiInterface.getInstance()

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
                    // startActivity(Intent(this@MainActivity, CounterMVVMActivity::class.java))
//                    lifecycleScope.launch {
//                        val result = newApi.store(
//                            NewsKtor(
//                                title = "News 11",
//                                desc = "This is news 11",
//                                image = "https://i.picsum.photos/id/166/200/200.jpg?hmac=lghN9aMZHsvaZQVmJW3_fCu5ArnsnX8kJwM87m9K9dY"
//                            )
//                        )
//
//                        var resultString = "News store status: "
//                        if (result.id == 0) {
//                            resultString += " FAILED"
//                        } else {
//                            resultString += " Success -> ${result.id}"
//                        }
//                        Toast.makeText(this@MainActivity, resultString, Toast.LENGTH_SHORT).show()
//                    }
                    startActivity(Intent(this@MainActivity, CalculatorComposeActivity::class.java))
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