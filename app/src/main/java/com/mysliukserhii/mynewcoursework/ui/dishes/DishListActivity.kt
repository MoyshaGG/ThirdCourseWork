package com.mysliukserhii.mynewcoursework.ui.dishes

import android.os.Bundle
import android.os.Handler
import android.util.Log
import android.view.MenuItem
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.mysliukserhii.mynewcoursework.R
import com.mysliukserhii.mynewcoursework.data.AppDataBase
import com.mysliukserhii.mynewcoursework.databinding.ActivityDishlistBinding


class DishListActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDishlistBinding
    private val viewModel: DishesViewModel by viewModels()
    private lateinit var dishesAdaptor: DishesListAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        setContentView(R.layout.activity_dishlist)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        binding = ActivityDishlistBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        val recyclerView = binding.dishListRecycleView
        recyclerView.apply {
            layoutManager =
                LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
            dishesAdaptor = DishesListAdapter()
            adapter = dishesAdaptor

        }
        viewModel.contentListLiveData.observe(this) {
            dishesAdaptor.setData(it)
            Log.i("BEB", it.toString())
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
}