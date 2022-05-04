package com.nguonchhay.inandroid2022.ui.fragments

import android.os.Bundle
import android.view.View
import android.widget.GridView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import com.nguonchhay.inandroid2022.R
import com.nguonchhay.inandroid2022.adapters.NewsGridViewAdapter
import com.nguonchhay.inandroid2022.data_class.News
import com.nguonchhay.inandroid2022.databinding.FragmentAllNewsBinding
import com.nguonchhay.inandroid2022.ui.viewmodels.AllNewsViewModel
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch


class AllFragment : Fragment(R.layout.fragment_all_news) {

    lateinit var binding: FragmentAllNewsBinding
    lateinit var viewModel: AllNewsViewModel

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentAllNewsBinding.bind(view)
        viewModel = ViewModelProvider(this)[AllNewsViewModel::class.java]

        binding.gvNews.numColumns = 3
        val spacing = 15
        binding.gvNews.verticalSpacing = spacing
        binding.gvNews.horizontalSpacing = spacing

        startObserve()
    }

    private fun startObserve() {
        lifecycleScope.launch {
            viewModel.dataObserver.collectLatest {
                binding.gvNews.adapter = NewsGridViewAdapter(it)
            }
        }
    }
}