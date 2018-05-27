package com.estyle.trainingkotlin.activities

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import com.bumptech.glide.Glide
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

        val codePics = intent.getIntArrayExtra("code_pics")
        mRecyclerView.adapter = DetailAdapter(codePics)
    }

    private class DetailAdapter(val codes: IntArray?) : RecyclerView.Adapter<DetailAdapter.DetailViewHolder>() {
        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DetailViewHolder {
            val itemView = LayoutInflater.from(parent.context)
                    .inflate(R.layout.item_detail_code, parent, false)
            return DetailViewHolder(itemView)
        }

        override fun getItemCount(): Int = codes?.size ?: 0

        override fun onBindViewHolder(holder: DetailViewHolder, position: Int) {
            val code = codes!![position]
            holder.bind(code)
        }

        class DetailViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

            val mImageView by lazy { itemView.findViewById<ImageView>(R.id.code_iv) }

             fun bind(resId: Int) {
                Glide.with(mImageView.context)
                        .load(resId)
                        .into(mImageView)
            }
        }
    }
}
