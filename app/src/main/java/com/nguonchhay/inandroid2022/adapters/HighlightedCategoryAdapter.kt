package com.nguonchhay.inandroid2022.adapters

import android.app.Activity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.nguonchhay.inandroid2022.R
import com.nguonchhay.inandroid2022.data_class.CategoryResponse

class HighlightedCategoryAdapter(val context: Activity, private val categories: List<CategoryResponse>) : RecyclerView.Adapter<HighlightedCategoryAdapter.HighlightedCategoryViewHolder>() {

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
        Glide.with(context).load(curCategory.image).into(categoryImageView)
    }

    override fun getItemCount(): Int {
        return categories.size
    }
}