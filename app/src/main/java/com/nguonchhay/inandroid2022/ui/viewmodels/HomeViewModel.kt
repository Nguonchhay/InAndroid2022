package com.nguonchhay.inandroid2022.ui.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.nguonchhay.inandroid2022.R
import com.nguonchhay.inandroid2022.data_class.CategoryResponse
import com.nguonchhay.inandroid2022.data_class.News
import com.nguonchhay.inandroid2022.data_class.NewsKtor
import com.nguonchhay.inandroid2022.data_class.NewsKtorResponse
import com.nguonchhay.inandroid2022.networks.apis.CategoriesApiInterface
import com.nguonchhay.inandroid2022.networks.apis.NewsApiInterface
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class HomeViewModel : ViewModel() {

    data class HomeData(
        val highlightedCategories: List<CategoryResponse> = emptyList(),
        val latestNews: List<NewsKtor> = emptyList<NewsKtor>()
    )

    private val _uiState = MutableStateFlow<HomeData>(HomeData())
    var uiState = _uiState.asStateFlow()

    val newsApi by lazy {
        NewsApiInterface.getInstance()
    }

    private val categoryApi by lazy {
        CategoriesApiInterface.getInstance()
    }

    init {
        viewModelScope.launch {
            val latestNewsResult = newsApi.list()
            val highlightedCategoriesResult = categoryApi.list()
            _uiState.value = HomeData(
                highlightedCategoriesResult.data,
                latestNewsResult.data
            )
        }
    }
}