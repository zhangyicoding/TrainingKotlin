package com.estyle.trainingkotlin.activities

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import android.support.v7.app.AppCompatActivity
import com.estyle.trainingkotlin.R
import com.estyle.trainingkotlin.fragments.*
import com.estyle.viewpager.transformer.*
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onPostCreate(savedInstanceState: Bundle?) {
        super.onPostCreate(savedInstanceState)

        viewPager.adapter = MainPagerAdapter(supportFragmentManager)
        viewPager.setPageTransformer(true, TabletTransformer())
    }

    private fun getFragmentList(): List<Fragment> {
        return ArrayList<Fragment>().apply {
            add(No01Fragment())
            add(No02Fragment())
            add(No03Fragment())
            add(No04Fragment())
        }
    }

    private inner class MainPagerAdapter(fm: FragmentManager) : FragmentPagerAdapter(fm) {
        override fun getItem(position: Int): Fragment = getFragmentList()[position]

        override fun getCount(): Int  = getFragmentList().size
    }

}
