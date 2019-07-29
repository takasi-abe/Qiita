package com.example.qiita


import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.fragment_item_list.*

class ArticleListFragment : Fragment() {

    //記事を取得するための
    private val qiitaFunction = QiitaFunction()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_item_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //記事情報の取得
        qiitaFunction.getArticleList {

            Log.d("fragment", "call")
            //RecyclerViewの指定
            val recyclerView = articleList
            val adapter = MyItemRecyclerViewAdapter(it, object : MyItemRecyclerViewAdapter.ArticleListener{
                override fun onClickRow(tappedView: View, articleItems: ArticleItems) {
                    Log.d("Adapter", "click[${articleItems.url}]")

                    //記事のwebページを表示する
                    callArticlePage(articleItems)

                }
            })

            //取得した記事の表示
            recyclerView.setHasFixedSize(true)
            recyclerView.adapter = adapter
            recyclerView.layoutManager = LinearLayoutManager(activity)
        }

    }

    /**
     * Webページを表示する
     * @param articleItems リストからタップした記事の情報
     */
    private fun callArticlePage(articleItems: ArticleItems) {

        Log.d("ArticleFragment", "called")
        val fragment = WebViewFragment(articleItems)
        val fragmentManager = activity?.supportFragmentManager
        val fragmentTransaction = fragmentManager?.beginTransaction()


        fragmentTransaction?.replace(R.id.container, fragment)?.commit()
    }
}
