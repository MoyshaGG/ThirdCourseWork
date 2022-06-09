package com.mysliukserhii.mynewcoursework

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.ListAdapter
import androidx.lifecycle.*
import androidx.recyclerview.widget.LinearLayoutManager
import com.mysliukserhii.mynewcoursework.adapter.DishesListAdapter
import com.mysliukserhii.mynewcoursework.databinding.ActivityDishlistBinding
import com.mysliukserhii.mynewcoursework.viewModel.SettingViewModel


class DishlistActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDishlistBinding
    private lateinit var viewModel: SettingViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dishlist)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        binding = ActivityDishlistBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        val recyclerView = binding.dishListRecycleView
        val adapter = DishesListAdapter()
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(this)
      //  recyclerView.layoutManager = LinearLayoutManager
        viewModel = ViewModelProvider(this).get(SettingViewModel::class.java)
        viewModel.readAllData.observe({ lifecycle }, { dishes ->
            adapter.dishesList
            val test = dishes

          //  adapter.setData(dishes)
        })
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