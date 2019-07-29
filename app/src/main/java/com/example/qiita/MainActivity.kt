package com.example.qiita

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button.setOnClickListener{
            Log.d("Main", "click")

            //記事一覧画面を表示
            callQiitaList()
        }
    }

    private fun callQiitaList() {
        val fragment = ArticleListFragment()
        val fragmentManager = this.supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()

        fragmentTransaction.replace(R.id.container, fragment)
            .commit()
    }
}
