package com.nguonchhay.inandroid2022.ui.fragments

import android.app.Activity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2
import com.nguonchhay.inandroid2022.R
import com.nguonchhay.inandroid2022.adapters.HighlightedCategoryAdapter
import com.nguonchhay.inandroid2022.adapters.LatestNewsAdapter
import com.nguonchhay.inandroid2022.data_class.News
import com.nguonchhay.inandroid2022.databinding.FragmentHomeBinding
import com.nguonchhay.inandroid2022.ui.viewmodels.HomeViewModel
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

class HomeFragment(val context: Activity) : Fragment(R.layout.fragment_home) {

    lateinit var binding: FragmentHomeBinding
    lateinit var viewModel: HomeViewModel

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this)[HomeViewModel::class.java]

        binding = FragmentHomeBinding.bind(view)
        binding.rvLatestNews.layoutManager = LinearLayoutManager(context)
        observeChange()
    }

    private fun observeChange() {
        lifecycleScope.launch {
            viewModel.uiState.collectLatest {
                binding.vpCategories.adapter = HighlightedCategoryAdapter(context, it.highlightedCategories)
                binding.rvLatestNews.adapter = LatestNewsAdapter(context, it.latestNews)
            }
        }
    }
}