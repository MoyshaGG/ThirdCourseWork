package com.mysliukserhii.mynewcoursework

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.Toolbar

class SettingsActivity : AppCompatActivity() {
    val days = arrayOf("Понеділок", "Вівторок", "Середа", "Четверг","П'ятниця", "Суббота","Неділя")
    val time = arrayOf("Сніданок", "Обід", "Вечеря")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_settings)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)


        val adapterDay: ArrayAdapter<String> =
            ArrayAdapter<String>(this, android.R.layout.simple_spinner_item,days)
        adapterDay.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        val adapterTime: ArrayAdapter<String> =
        ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, time)
        adapterTime.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)

    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        when (item.itemId) {
            android.R.id.home -> {
                finish()
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }
}