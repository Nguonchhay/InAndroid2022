package com.nguonchhay.inandroid2022.ui.viewmodels

import androidx.lifecycle.ViewModel
import com.nguonchhay.inandroid2022.R
import com.nguonchhay.inandroid2022.data_class.News
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class HomeViewModel : ViewModel() {

    data class HomeData(
        val highlightedCategories: List<Int> = emptyList<Int>(),
        val latestNews: List<News> = emptyList<News>()
    )

    private val _uiState = MutableStateFlow<HomeData>(HomeData())
    var uiState = _uiState.asStateFlow()

    init {
        // Call API or mock data
        val highLightedCategories = listOf<Int>(
            R.drawable.cate_1,
            R.drawable.cate_2,
            R.drawable.cate_3
        )
        val latestNews = listOf<News>(
            News(R.drawable.news1, "News 1", "You can specify how many words should be generated right next to the word lorem. For example, lorem5 will generate a 5-words dummy text."),
            News(R.drawable.news2, "News 2", "You can specify how many words should be generated right next to the word lorem. For example, lorem5 will generate a 5-words dummy text."),
            News(R.drawable.news3, "News 3", "You can specify how many words should be generated right next to the word lorem. For example, lorem5 will generate a 5-words dummy text."),
            News(R.drawable.news4, "News 4", "You can specify how many words should be generated right next to the word lorem. For example, lorem5 will generate a 5-words dummy text.")
        )
        _uiState.value = HomeData(highLightedCategories, latestNews)
    }
}