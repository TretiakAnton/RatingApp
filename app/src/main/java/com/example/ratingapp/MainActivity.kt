package com.example.ratingapp


import android.os.Bundle
import android.os.StrictMode
import android.os.StrictMode.VmPolicy
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager.widget.ViewPager
import com.google.android.material.tabs.TabLayout


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        // StrictMode is a developer tool which detects things you might be doing by accident and brings them to your attention so you can fix them.
        StrictMode.setVmPolicy(
            VmPolicy.Builder()
                .detectLeakedClosableObjects()
                .penaltyLog()
                .build()
        )
        StrictMode.enableDefaults()
        super.onCreate(savedInstanceState)

        // Set the content of the activity to use the activity_main.xml layout file
        setContentView(R.layout.activity_main)

        // Find the view pager that will allow the user to swipe between fragments
        val viewPager = findViewById<View>(R.id.viewpager) as ViewPager

        // Create an adapter that knows which fragment should be shown on each page
        val adapter = CategoryAdapter(this, supportFragmentManager)

        // Set the adapter onto the view pager
        viewPager.adapter = adapter

        // Find the tab layout that shows the tabs
        val tabLayout = findViewById<View>(R.id.tabs) as TabLayout

        // Connect the tab layout with the view pager. This will
        //   1. Update the tab layout when the view pager is swiped
        //   2. Update the view pager when a tab is selected
        //   3. Set the tab layout's tab names with the view pager's adapter's titles
        //      by calling onPageTitle()
        tabLayout.setupWithViewPager(viewPager)
    }
}