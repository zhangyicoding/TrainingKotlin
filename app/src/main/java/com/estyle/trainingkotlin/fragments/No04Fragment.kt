package com.estyle.trainingkotlin.fragments

import android.animation.Animator
import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.support.v7.widget.RecyclerView
import android.support.v7.widget.RecyclerView.Adapter
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.estyle.trainingkotlin.R
import com.estyle.trainingkotlin.activities.CodeDetailActivity
import com.estyle.trainingkotlin.activities.EndActivity
import kotlinx.android.synthetic.main.fragment_04.*

class No04Fragment : BaseFragment() {
    override fun onAnimEnd(animation: Animator) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override var mPage: Int
        get() = 4
        set(value) {}

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_04, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        collapsingToolbarLayout.setExpandedTitleColor(Color.WHITE)
        collapsingToolbarLayout.setCollapsedTitleTextColor(Color.BLACK)

        toEndBtn.setOnClickListener { startActivity(Intent(context, EndActivity::class.java)) }

        recyclerView.adapter = CodeAdapter(listOf(
                "环境搭建",
                "变量、常量、数据类型",
                "函数",
                "if语句",
                "when语句",
                "for语句",
                "List集合",
                "伴生对象",
                "lambda表达式"
        ))
    }

    override fun onTitleClick() {
    }

    private class CodeAdapter(val datas: List<String>?) : Adapter<CodeAdapter.CodeViewHolder>() {
        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CodeViewHolder {
            val itemView = LayoutInflater.from(parent.context)
                    .inflate(R.layout.item_code, parent, false)
            itemView.setOnClickListener {
                parent.context.startActivity(Intent(parent.context, CodeDetailActivity::class.java).apply {
                    putExtra("title",
                            datas?.get((parent as RecyclerView).getChildLayoutPosition(itemView))
                                    ?: "")
                })
            }
            return CodeViewHolder(itemView)
        }

        override fun getItemCount(): Int {
            return datas?.size ?: 0
        }

        override fun onBindViewHolder(holder: CodeViewHolder, position: Int) {
            val title = datas?.get(position) ?: ""
            holder.bind(title)

        }

        class CodeViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

            val titleTextView by lazy { itemView.findViewById<TextView>(R.id.titleTextView) }

            fun bind(title: String) {
                titleTextView.text = title
            }
        }

    }

}