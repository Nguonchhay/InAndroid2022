package com.nguonchhay.inandroid2022.ui.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.nguonchhay.inandroid2022.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {

    lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater);
        setContentView(binding.root)

        binding.lblRegister.setOnClickListener {
            startActivity(
                Intent(this@LoginActivity, RegisterActivity::class.java)
            )
        }

        binding.btnLogin.setOnClickListener {
            val emailValue = binding.editEmail.text.toString()
            val passwordValue = binding.editPassword.text.toString()
            if (emailValue == "" || passwordValue == "") {
                Toast.makeText(this, "Fields are required!", Toast.LENGTH_SHORT).show()
            } else {
                // @TODO: Call login API

                startActivity(
                    Intent(this, MainActivity::class.java)
                )
            }
        }
    }
}