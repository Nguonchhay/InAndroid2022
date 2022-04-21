package com.nguonchhay.inandroid2022.ui.activities

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.viewpager2.widget.ViewPager2
import com.nguonchhay.inandroid2022.R
import com.nguonchhay.inandroid2022.adapters.HighlightedCategoryAdapter

class HomeFragment : Fragment(R.layout.fragment_home) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val highLightedCategories = listOf<Int>(
            R.drawable.cate_1,
            R.drawable.cate_2,
            R.drawable.cate_3
        )

        val adapter = HighlightedCategoryAdapter(highLightedCategories)
        val vpCategory = view.findViewById<ViewPager2>(R.id.vpCategories)
        vpCategory.adapter = adapter
    }
}