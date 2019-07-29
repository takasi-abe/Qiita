package com.example.qiita

import android.util.Log
import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout


import com.squareup.picasso.Picasso

import kotlinx.android.synthetic.main.fragment_item.view.*

class MyItemRecyclerViewAdapter(
    private val mValues: List<ArticleItems>,
    private val mListener: ArticleListener
) : RecyclerView.Adapter<MyItemRecyclerViewAdapter.ViewHolder>() {

    //ViewHolderを作成(表示するデータを格納する入れ物を作る)
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.fragment_item, parent, false)
        return ViewHolder(view)
    }

    //各データをホルダーにバインド(ホルダーにどれがどのデータかを振り分けて保存する)
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val iconSize = 60

        val item = mValues[position]
        val transformation = RoundedTransformation()
        holder.titleView.text = item.title
        holder.dateView.text = item.date
        holder.userNameView.text = item.user.userName
        Picasso.get()
            .load(item.user.icon)
            .resize(iconSize,iconSize)
            .transform(transformation)
            .into(holder.iconView)

        holder.articleLayout.setOnClickListener {
            mListener.onClickRow(it, item)
        }

    }

    //Itemの数を取得
    override fun getItemCount(): Int = mValues.size

    //ViewHolderを作成(リストに表示する内容)
    inner class ViewHolder(mView: View) : RecyclerView.ViewHolder(mView) {

        val titleView: TextView = mView.title
        val dateView: TextView = mView.date
        val userNameView: TextView = mView.user_name
        val iconView: ImageView = mView.icon
        val articleLayout: ConstraintLayout = mView.articleLayout
    }

    interface ArticleListener {
        fun onClickRow(tappedView: View, articleItems: ArticleItems)
    }

}
