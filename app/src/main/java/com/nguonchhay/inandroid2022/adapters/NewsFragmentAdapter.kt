package com.nguonchhay.inandroid2022.adapters

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter

class NewsFragmentAdapter(
    val fragments: List<Fragment>,
    val fragmentManager: FragmentManager,
    val lifecycle: Lifecycle
) : FragmentStateAdapter(fragmentManager, lifecycle) {

    override fun getItemCount(): Int = fragments.size
    override fun createFragment(position: Int) = fragments[position]
}