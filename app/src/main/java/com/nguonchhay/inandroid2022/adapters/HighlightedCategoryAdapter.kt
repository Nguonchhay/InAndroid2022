package com.nguonchhay.inandroid2022.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.nguonchhay.inandroid2022.R

class HighlightedCategoryAdapter(private val categories: List<Int>) : RecyclerView.Adapter<HighlightedCategoryAdapter.HighlightedCategoryViewHolder>() {

    inner class HighlightedCategoryViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {}

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): HighlightedCategoryViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_highlighted_category, parent, false)
        return HighlightedCategoryViewHolder(view)
    }

    override fun onBindViewHolder(holder: HighlightedCategoryViewHolder, position: Int) {
        val curCategory = categories[position]
        val categoryImageView: ImageView = holder.itemView.findViewById(R.id.categoryImage)
        categoryImageView.setImageResource(curCategory)
    }

    override fun getItemCount(): Int {
        return categories.size
    }
}