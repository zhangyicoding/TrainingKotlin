package com.estyle.trainingkotlin.activities

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.estyle.trainingkotlin.R
import kotlinx.android.synthetic.main.activity_code_detail.*

class CodeDetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_code_detail)
    }

    override fun onPostCreate(savedInstanceState: Bundle?) {
        super.onPostCreate(savedInstanceState)
        titlebar.title = intent.getStringExtra("title")
        titlebar.setNavigationOnClickListener { finish() }
    }
}
