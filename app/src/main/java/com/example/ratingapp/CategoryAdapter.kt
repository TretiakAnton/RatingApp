package com.example.ratingapp

import android.content.Context
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter

class CategoryAdapter
    (
    private val mContext: Context, fm: FragmentManager?
) :
    FragmentPagerAdapter(fm!!) {

    override fun getItem(position: Int): Fragment {
        return if (position == 0) {
            StartFragment()
        } else {
            FavouriteFragment()
        }
    }

    override fun getCount(): Int {
        return 2
    }

    override fun getPageTitle(position: Int): CharSequence {
        return if (position == 0) {
            mContext.getString(R.string.category_start)
        } else {
            mContext.getString(R.string.category_favourite)
        }
    }
}
