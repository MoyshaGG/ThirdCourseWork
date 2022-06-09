package com.mysliukserhii.mynewcoursework.ui.dishes

import androidx.appcompat.app.AppCompatActivity
import com.mysliukserhii.mynewcoursework.databinding.ActivityDishlistBinding

class Dishes: AppCompatActivity(), OnItemClick {
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
            adapter.setData(dishes)
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

    override fun onClick(dishId: Int) {
        finish()
    }
}