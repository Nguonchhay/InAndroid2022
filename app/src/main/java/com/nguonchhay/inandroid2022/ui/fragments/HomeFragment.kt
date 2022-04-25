package com.nguonchhay.inandroid2022.ui.fragments

import android.app.Activity
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2
import com.nguonchhay.inandroid2022.R
import com.nguonchhay.inandroid2022.adapters.HighlightedCategoryAdapter
import com.nguonchhay.inandroid2022.adapters.LatestNewsAdapter
import com.nguonchhay.inandroid2022.data_class.News

class HomeFragment(val context: Activity) : Fragment(R.layout.fragment_home) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Define static data for ViewPager
        val highLightedCategories = listOf<Int>(
            R.drawable.cate_1,
            R.drawable.cate_2,
            R.drawable.cate_3
        )
        val adapter = HighlightedCategoryAdapter(highLightedCategories)
        val vpCategory = view.findViewById<ViewPager2>(R.id.vpCategories)
        vpCategory.adapter = adapter

        // Define static data for RecyclerView
        /**
         * News: image, title, short description
         */
        val latestNews = listOf<News>(
            News(R.drawable.news1, "News 1", "You can specify how many words should be generated right next to the word lorem. For example, lorem5 will generate a 5-words dummy text."),
            News(R.drawable.news2, "News 2", "You can specify how many words should be generated right next to the word lorem. For example, lorem5 will generate a 5-words dummy text."),
            News(R.drawable.news3, "News 3", "You can specify how many words should be generated right next to the word lorem. For example, lorem5 will generate a 5-words dummy text."),
            News(R.drawable.news4, "News 4", "You can specify how many words should be generated right next to the word lorem. For example, lorem5 will generate a 5-words dummy text.")
        )
        val latestNewsAdapter = LatestNewsAdapter(context, latestNews)
        val rvLatestNews = view.findViewById<RecyclerView>(R.id.rvLatestNews)
        rvLatestNews.adapter = latestNewsAdapter
        rvLatestNews.layoutManager = LinearLayoutManager(context)
    }
}