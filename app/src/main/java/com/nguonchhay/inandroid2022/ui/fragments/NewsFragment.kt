package com.nguonchhay.inandroid2022.ui.fragments

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import com.nguonchhay.inandroid2022.R
import com.nguonchhay.inandroid2022.adapters.NewsFragmentAdapter

class NewsFragment(
    val fm: FragmentManager,
    val lc: Lifecycle
) : Fragment(R.layout.fragment_news) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val tabCategory = view.findViewById<TabLayout>(R.id.tabCategory)

        val categories = listOf<String>(
            "All",
            "Technology",
            "Food"
        )

        val fragments = listOf<Fragment>(
            AllFragment(),
            TechnologyFragment(),
            FoodFragment()
        )
        val newsAdapter = NewsFragmentAdapter(fragments, fm, lc)
        val vpNewsFragment = view.findViewById<ViewPager2>(R.id.vpNewsFragment)
        vpNewsFragment.adapter = newsAdapter

        TabLayoutMediator(tabCategory, vpNewsFragment) { tab, position ->
            tab.text = categories[position]
        }.attach()
    }
}