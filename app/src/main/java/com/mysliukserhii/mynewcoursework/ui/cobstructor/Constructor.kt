package com.mysliukserhii.mynewcoursework.ui.cobstructor

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import androidx.appcompat.app.AppCompatActivity
import com.mysliukserhii.mynewcoursework.databinding.ActivityConstructorBinding

class Constructor: AppCompatActivity(), View.OnClickListener {
    val days = arrayOf("Понеділок", "Вівторок","Середа","Четверг","П'ятниця","Суббота")
    lateinit var binding:ActivityConstructorBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityConstructorBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val adapter: ArrayAdapter<String> = ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, days)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        binding.spinner.adapter = adapter
        binding.intentButton.setOnClickListener(this)
        binding.breakfast.setOnClickListener{
            //selectDish(1,1)
            selectDish()
        }
//        binding.lunch.setOnClickListener{selectDish(2,2)}
//        binding.dinner.setOnClickListener{selectDish(3,4)}

    }
    fun selectDish(
        // time:Int,day:Int
    ){
        val intent = Intent(this, DishlistActivity::class.java)
//        intent.putExtra("time",time)
//        intent.putExtra("day",day)

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
        val intent = Intent(this, SettingsActivity::class.java).apply {
        }
        startActivity(intent)
    }
} {
}