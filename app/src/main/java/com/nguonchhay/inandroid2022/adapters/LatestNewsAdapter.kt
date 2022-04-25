package com.nguonchhay.inandroid2022.adapters

import android.app.Activity
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.nguonchhay.inandroid2022.R
import com.nguonchhay.inandroid2022.data_class.News
import com.nguonchhay.inandroid2022.ui.activities.NewsDetailActivity

class LatestNewsAdapter(val context: Activity, val newsData: List<News>) : RecyclerView.Adapter<LatestNewsAdapter.ViewHolder>() {

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
       val view = LayoutInflater.from(parent.context).inflate(R.layout.item_latest_news, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val newItem = newsData[position]
        val imageView: ImageView = holder.itemView.findViewById(R.id.newsImage)
        imageView.setImageResource(newItem.image)

        val titleView: TextView = holder.itemView.findViewById(R.id.newsTitle)
        titleView.text = newItem.title

        val descriptionView: TextView = holder.itemView.findViewById(R.id.newsDesc)
        descriptionView.text = newItem.desc

        holder.itemView.setOnClickListener {
            val intent = Intent(context, NewsDetailActivity::class.java)
            intent.putExtra("NEWS_IMAGE", newItem.image.toString())
            intent.putExtra("NEWS_TITLE", newItem.title)
            intent.putExtra("NEWS_DESC", newItem.desc)
            context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
        return newsData.size
    }
}