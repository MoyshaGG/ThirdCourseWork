package com.mysliukserhii.mynewcoursework.adapter
import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.mysliukserhii.mynewcoursework.R
import com.mysliukserhii.mynewcoursework.databinding.ItemDishBinding
import com.mysliukserhii.mynewcoursework.dishes.Dishes


interface OnItemClick {
    fun onClick(appId: Int)
}

class DishListAdapter(private val onItemClick: OnItemClick) :
    ListAdapter<Dishes, DishListAdapter.AppHolder>(object : DiffUtil.ItemCallback<Dishes>() {
        override fun areItemsTheSame(
            oldItem: Dishes,
            newItem: Dishes
        ): Boolean = oldItem.dish_id == newItem.dish_id

        override fun areContentsTheSame(
            oldItem: Dishes,
            newItem: Dishes
        ): Boolean = oldItem == newItem
    }) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AppHolder {
        return AppHolder(
            ItemDishBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: AppHolder, position: Int) {
        holder.bind(getItem(position), holder.itemView.context)
    }

    inner class AppHolder(binding: ItemDishBinding) : RecyclerView.ViewHolder(binding.root) {
        private val dishnameTextView: TextView = binding.dishname
        private val kkalTextView: TextView = binding.kkal


        fun bind(item: Dishes, context: Context) {
            dishnameTextView.text = item.name
            kkalTextView.text = item.cal
            itemView.setOnClickListener {
                onItemClick.onClick(item.dish_id)
            }
        }
    }
}
