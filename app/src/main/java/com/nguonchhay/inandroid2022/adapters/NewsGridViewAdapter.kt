package com.nguonchhay.inandroid2022.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import com.nguonchhay.inandroid2022.R
import com.nguonchhay.inandroid2022.data_class.News

class NewsGridViewAdapter(val newsData: List<News>) : BaseAdapter() {

    override fun getCount(): Int = newsData.size

    override fun getItem(position: Int): Any = newsData[position]

    override fun getItemId(position: Int): Long = position.toLong()

    override fun getView(position: Int, view: View?, parent: ViewGroup?): View {
        val inflater = parent?.context?.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val view = inflater.inflate(R.layout.item_news_gridview, null)

        val newsItem = newsData[position]
        val imageView = view.findViewById<ImageView>(R.id.newsImage)
        imageView.setImageResource(newsItem.image)

        val titleView = view.findViewById<TextView>(R.id.newsTitle)
        titleView.text = newsItem.title

        return view
    }
}