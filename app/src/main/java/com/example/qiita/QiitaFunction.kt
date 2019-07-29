package com.example.qiita

import android.util.Log
import okhttp3.OkHttpClient
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import java.util.*


class QiitaFunction {

    private var articleItemService: ArticleItemService.ArticleService

    init {
        //OkHttpをクライアントとしてビルド
        var client = OkHttpClient.Builder().build()

        //Moshiをコンバーターとしてビルド
        val moshi = Moshi.Builder()
            .add(KotlinJsonAdapterFactory())
            .build()

        //Retrofitをビルド
        val retrofit = Retrofit.Builder()
            .baseUrl("https://qiita.com/api/v2/")
            .addConverterFactory(MoshiConverterFactory.create(moshi))
            .client(client)
            .build()

        //記事を取得する際の条件の指定
        articleItemService = retrofit.create(ArticleItemService.ArticleService::class.java)
        Log.d("QiitaFunction", "Init")
    }

    /**
     * API使用時にレスポンスが帰ってきた場合、Qiita記事をリストに格納(onResponce)
     * レスポンスが帰ってこなかった場合エラーを表示(onFailure)
     */
    fun getArticleList(callback: (List<ArticleItems>) -> Unit) {
        articleItemService.articles(page = 1, perPage = 2).enqueue(object : Callback<List<ArticleItems>> {


            //レスポンスが帰ってきた場合
            override fun onResponse(call: Call<List<ArticleItems>>, response: Response<List<ArticleItems>>) {
                response?.let {

                    //レスポンスが正しく帰ってきた場合
                    if (response.isSuccessful) {
                        Log.d("getArticleList", "onResponce")

                        response.body()?.let {
                            callback(it)
                        }
                    }
                }
            }

            //レスポンスが帰ってこなかった場合
            override fun onFailure(call: Call<List<ArticleItems>>, t: Throwable) {
//                callError()
                Log.d("getArticleList", "onFailure")
            }
        })
    }

}