package com.nguonchhay.inandroid2022.ui.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import android.widget.Toast
import com.nguonchhay.inandroid2022.R
import com.nguonchhay.inandroid2022.databinding.ActivityRegister2Binding
import com.nguonchhay.inandroid2022.extensions.hideSoftKeyboard

class Register2Activity : AppCompatActivity() {

    lateinit var binding : ActivityRegister2Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegister2Binding.inflate(layoutInflater)
        setContentView(binding.root)

        // val genderItems = listOf("Male", "Female", "Other")
        val genderItems = resources.getStringArray(R.array.GenderItems)
        val genderAdapter = ArrayAdapter(this, R.layout.list_gender_items, genderItems)
        (binding.genderWrapper.editText as? AutoCompleteTextView)?.setAdapter(genderAdapter)
//        (binding.genderWrapper.editText as? AutoCompleteTextView)?.setOnItemClickListener { adapterView, view, i, l ->
//            Toast.makeText(this@Register2Activity, "Item = " + genderItems[i], Toast.LENGTH_SHORT).show()
//        }

        binding.btnRegister.setOnClickListener {
            if (binding.emailWrapper.editText?.text.toString() == "") {
                binding.emailWrapper.error = "Email is required!"
            } else {
                binding.emailWrapper.error = null
            }

            if (binding.passwordWrapper.editText?.text.toString() == "") {
                binding.passwordWrapper.error = "Password is required!"
            } else {
                binding.passwordWrapper.error = null
            }
        }

        binding.layoutRegister.setOnClickListener {
            hideSoftKeyboard()
        }
    }
}