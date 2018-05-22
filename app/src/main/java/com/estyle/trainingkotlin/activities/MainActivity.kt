package com.estyle.trainingkotlin.activities

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import com.estyle.trainingkotlin.R
import com.estyle.trainingkotlin.fragments.BaseFragment

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    private fun getFragmentList():List<Fragment> {
        return ArrayList<Fragment>().apply {
            for (page in 1..BaseFragment.sTotalCount) {

            }
        }
    }

}
