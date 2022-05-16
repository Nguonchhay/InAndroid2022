package com.nguonchhay.inandroid2022.ui.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.nguonchhay.inandroid2022.R
import com.nguonchhay.inandroid2022.data_class.News
import com.nguonchhay.inandroid2022.data_class.NewsRetrofit
import com.nguonchhay.inandroid2022.networks.RetrofitClient
import com.nguonchhay.inandroid2022.networks.apis.NewsApiRetrofit
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class AllNewsViewModel : ViewModel() {

    private val viewModelEmitter = MutableStateFlow<List<NewsRetrofit>>(emptyList())
    val dataObserver = viewModelEmitter.asStateFlow()

    val newsApi = RetrofitClient.getInstance().create(NewsApiRetrofit::class.java)

    init {
//        val newsList = listOf<News>(
//            News(R.drawable.news1, "News 1", "You can specify how many words should be generated right next to the word lorem. For example, lorem5 will generate a 5-words dummy text."),
//            News(R.drawable.news2, "News 2", "You can specify how many words should be generated right next to the word lorem. For example, lorem5 will generate a 5-words dummy text."),
//            News(R.drawable.news3, "News 3", "You can specify how many words should be generated right next to the word lorem. For example, lorem5 will generate a 5-words dummy text."),
//            News(R.drawable.news4, "News 4", "You can specify how many words should be generated right next to the word lorem. For example, lorem5 will generate a 5-words dummy text."),
//            News(R.drawable.news1, "News 5", "You can specify how many words should be generated right next to the word lorem. For example, lorem5 will generate a 5-words dummy text."),
//            News(R.drawable.news2, "News 6", "You can specify how many words should be generated right next to the word lorem. For example, lorem5 will generate a 5-words dummy text."),
//            News(R.drawable.news3, "News 7", "You can specify how many words should be generated right next to the word lorem. For example, lorem5 will generate a 5-words dummy text."),
//            News(R.drawable.news4, "News 8", "You can specify how many words should be generated right next to the word lorem. For example, lorem5 will generate a 5-words dummy text.")
//        )
        viewModelScope.launch {
            val result = newsApi.list()
            viewModelEmitter.value = result
        }
    }
}