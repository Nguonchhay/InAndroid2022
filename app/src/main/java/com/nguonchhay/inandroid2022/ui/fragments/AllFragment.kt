package com.nguonchhay.inandroid2022.ui.fragments

import android.os.Bundle
import android.view.View
import android.widget.GridView
import androidx.fragment.app.Fragment
import com.nguonchhay.inandroid2022.R
import com.nguonchhay.inandroid2022.adapters.NewsGridViewAdapter
import com.nguonchhay.inandroid2022.data_class.News


class AllFragment : Fragment(R.layout.fragment_all_news) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val newsList = listOf<News>(
            News(R.drawable.news1, "News 1", "You can specify how many words should be generated right next to the word lorem. For example, lorem5 will generate a 5-words dummy text."),
            News(R.drawable.news2, "News 2", "You can specify how many words should be generated right next to the word lorem. For example, lorem5 will generate a 5-words dummy text."),
            News(R.drawable.news3, "News 3", "You can specify how many words should be generated right next to the word lorem. For example, lorem5 will generate a 5-words dummy text."),
            News(R.drawable.news4, "News 4", "You can specify how many words should be generated right next to the word lorem. For example, lorem5 will generate a 5-words dummy text."),
            News(R.drawable.news1, "News 5", "You can specify how many words should be generated right next to the word lorem. For example, lorem5 will generate a 5-words dummy text."),
            News(R.drawable.news2, "News 6", "You can specify how many words should be generated right next to the word lorem. For example, lorem5 will generate a 5-words dummy text."),
            News(R.drawable.news3, "News 7", "You can specify how many words should be generated right next to the word lorem. For example, lorem5 will generate a 5-words dummy text."),
            News(R.drawable.news4, "News 8", "You can specify how many words should be generated right next to the word lorem. For example, lorem5 will generate a 5-words dummy text.")
        )
        val gvAdapter = NewsGridViewAdapter(newsList)
        val gvNews = view.findViewById<GridView>(R.id.gvNews)
        gvNews.adapter = gvAdapter
        gvNews.numColumns = 2
        val spacing = 15
        gvNews.verticalSpacing = spacing
        gvNews.horizontalSpacing = spacing
    }
}