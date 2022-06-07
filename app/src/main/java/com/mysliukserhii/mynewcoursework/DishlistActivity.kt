package com.mysliukserhii.mynewcoursework

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.lifecycle.ViewModelProvider
import com.mysliukserhii.mynewcoursework.adapter.DishListAdapter
import com.mysliukserhii.mynewcoursework.adapter.OnItemClick
import com.mysliukserhii.mynewcoursework.databinding.ActivityDishlistBinding
import com.mysliukserhii.mynewcoursework.viewModel.DishListViewModel



class DishlistActivity : AppCompatActivity(), OnItemClick {
    private lateinit var binding: ActivityDishlistBinding
    private lateinit var viewModel: DishListViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dishlist)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        binding = ActivityDishlistBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        val recyclerView = binding.dishListRecycleView
        val adapter = DishListAdapter(this)
        recyclerView.adapter = adapter

        viewModel = ViewModelProvider(this)[DishListViewModel::class.java]
        viewModel.dishes.observe(this) {
            it?.let {
                adapter.submitList(it)
            }
        }
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

    override fun onClick(dishId: Int) {
        finish()
    }
}