package com.mysliukserhii.mynewcoursework

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.view.MenuItem
import android.widget.*
import androidx.lifecycle.ViewModelProvider
import com.mysliukserhii.mynewcoursework.dishes.Dishes
import com.mysliukserhii.mynewcoursework.viewModel.SettingViewModel

class SettingsActivity : AppCompatActivity() {
    val days = arrayOf("Понеділок", "Вівторок", "Середа", "Четверг","П'ятниця", "Суббота","Неділя")
    val time = arrayOf("Сніданок", "Обід", "Вечеря")


    private lateinit var settingsViewModel: SettingViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_settings)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        settingsViewModel = ViewModelProvider(this).get(SettingViewModel::class.java)
        val add_button: Button = findViewById(R.id.add_button)

        val adapterDay: ArrayAdapter<String> =
            ArrayAdapter<String>(this, android.R.layout.simple_spinner_item,days)
        adapterDay.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        val adapterTime: ArrayAdapter<String> =
        ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, time)
        adapterTime.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        add_button.setOnClickListener{
            insertDataToDatabase()
        }
    }

    private fun insertDataToDatabase(){
        val calDishText: EditText = findViewById(R.id.calDishText)
        val dishNameText: EditText = findViewById(R.id.nameDishText)
        val calDish = calDishText.text.toString()
        val dishName = dishNameText.text.toString()
        if(inputCheck(calDish,dishName))
        {
            val dish =  Dishes(0,dishName,calDish)
            settingsViewModel.addDishes(dish)
            Toast.makeText(this,"Dishes has been added", Toast.LENGTH_LONG).show()
        }
        else{
            Toast.makeText(this,"Bastard, fill out all fields!", Toast.LENGTH_LONG).show()
        }
    }

    private fun inputCheck(calDish:String,dishname:String): Boolean {
        return!(TextUtils.isEmpty(calDish)&&TextUtils.isEmpty(dishname))
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