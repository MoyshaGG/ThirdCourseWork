package com.mysliukserhii.mynewcoursework.ui.dishes

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.mysliukserhii.mynewcoursework.R

class DishesListAdapter : RecyclerView.Adapter<DishesListAdapter.DishesListViewHolder>() {
    private var dishesList = emptyList<Dishes>()

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): DishesListAdapter.DishesListViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_dish, parent, false)
        return DishesListViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: DishesListAdapter.DishesListViewHolder, position: Int) {
        holder.bind(dishesList[position])
    }

    override fun getItemCount() = dishesList.size

    inner class DishesListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val dishname = itemView.findViewById<TextView>(R.id.dishname)
        val kkal:TextView = itemView.findViewById(R.id.kkal)

        fun bind(data: Dishes) {

        }

    }
    fun setData(dishes: List<Dishes>)
    {
        this.dishesList = dishes
        notifyDataSetChanged()
    }
}