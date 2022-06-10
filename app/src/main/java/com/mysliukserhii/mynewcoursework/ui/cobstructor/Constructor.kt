package com.mysliukserhii.mynewcoursework.ui.cobstructor

import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import android.widget.ArrayAdapter
import androidx.appcompat.app.AppCompatActivity
import com.mysliukserhii.mynewcoursework.databinding.ActivityConstructorBinding
import com.mysliukserhii.mynewcoursework.ui.add_dish.AddDishActivity
import com.mysliukserhii.mynewcoursework.ui.dishes.DishListActivity

class Constructor : AppCompatActivity(), View.OnClickListener {
    val days = arrayOf("Понеділок", "Вівторок", "Середа", "Четверг", "П'ятниця", "Суббота")
    private lateinit var binding: ActivityConstructorBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityConstructorBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val adapter: ArrayAdapter<String> =
            ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, days)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        binding.spinner.adapter = adapter
        binding.intentButton.setOnClickListener(this)
        binding.breakfast.setOnClickListener {

            selectDish()
        }
        binding.lunch.setOnClickListener {
            selectDish()
        }
        binding.breakfast.setOnClickListener {
            selectDish()
        }
        binding.dinner.setOnClickListener {
            selectDish()
        }
    }

    private fun selectDish() {
        val intent = Intent(this, DishListActivity::class.java)
        startActivity(intent)


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


    override fun onClick(v: View?) {
        val intent = Intent(this, AddDishActivity::class.java)
        startActivity(intent)
    }
}
