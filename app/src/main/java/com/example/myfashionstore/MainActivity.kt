package com.example.myfashionstore

import android.os.Bundle
import android.view.FrameMetrics
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.tabs.TabLayout
import androidx.viewpager.widget.ViewPager
import androidx.appcompat.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import androidx.fragment.app.Fragment
import com.example.myfashionstore.ui.main.ChildrenStoreFragment
import com.example.myfashionstore.ui.main.MenStoreFragment
import com.example.myfashionstore.ui.main.SectionsPagerAdapter
import com.example.myfashionstore.ui.main.WomenStoreFragment

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val fragments=ArrayList<Fragment>()
        fragments.add(MenStoreFragment())
        fragments.add(WomenStoreFragment())
        fragments.add(ChildrenStoreFragment())
        val sectionsPagerAdapter = SectionsPagerAdapter(this, supportFragmentManager,fragments)
        val viewPager: ViewPager = findViewById(R.id.view_pager)
        viewPager.adapter = sectionsPagerAdapter
        val tabs: TabLayout = findViewById(R.id.tabs)
        tabs.setupWithViewPager(viewPager)
        val fab: FloatingActionButton = findViewById(R.id.fab)

        viewPager.offscreenPageLimit=3
        fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show()
        }
    }
}