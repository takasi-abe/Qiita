package com.example.qiita

import android.util.Log
import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView


import com.example.qiita.ItemFragment.OnListFragmentInteractionListener
import com.squareup.picasso.Picasso

import kotlinx.android.synthetic.main.fragment_item.view.*

class MyItemRecyclerViewAdapter(
    private val mValues: List<ArticleItems>
//    private val mListener: OnListFragmentInteractionListener?
) : RecyclerView.Adapter<MyItemRecyclerViewAdapter.ViewHolder>() {

    //リストタップ時
    private val mOnClickListener: View.OnClickListener

    init {
        mOnClickListener = View.OnClickListener { v ->
            val item = v.tag as ArticleItems
            // Notify the active callbacks interface (the activity, if the fragment is attached to
            // one) that an item has been selected.
//            mListener?.onListFragmentInteraction(item)
        }
    }

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

        with(holder.mView) {
            tag = item
            setOnClickListener(mOnClickListener)
        }
    }

    //Itemの数を取得(RecyclerViewでいくつのデータを表示するかを決める)
    override fun getItemCount(): Int = mValues.size

    //ViewHolderを作成(リストに表示する内容)
    inner class ViewHolder(val mView: View) : RecyclerView.ViewHolder(mView) {
        val titleView: TextView = mView.title
        val dateView: TextView = mView.date
        val userNameView: TextView = mView.user_name
        val iconView: ImageView = mView.icon
    }
}
