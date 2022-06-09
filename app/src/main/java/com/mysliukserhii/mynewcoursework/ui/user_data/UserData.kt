package com.mysliukserhii.mynewcoursework.ui.user_data

import androidx.appcompat.app.AppCompatActivity

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import android.widget.Spinner
import com.mysliukserhii.mynewcoursework.R
import com.mysliukserhii.mynewcoursework.databinding.ActivityMainBinding
import com.mysliukserhii.mynewcoursework.ui.cobstructor.Constructor


class UserData : AppCompatActivity(), View.OnClickListener {
    lateinit var binding: ActivityMainBinding
    val countries = arrayOf("Чоловік", "Жіноча", "Гендерфлюід")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        val spinner = findViewById<Spinner>(R.id.spinner)

        val adapter: ArrayAdapter<String> =
            ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, countries)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinner.adapter = adapter

        binding.applyButton.setOnClickListener(this)

    }


    fun iMT(heightUser: Int, weightUser: Int) {
        var imtUser = (heightUser / ((weightUser * weightUser) / 2))
        if (imtUser > 5) {

        } else if (imtUser < 5 && imtUser > 2.5) {

        }
    }

    override fun onClick(v: View?) {
        val intent = Intent(this, Constructor::class.java).apply {
        }
        startActivity(intent)

    }
}
