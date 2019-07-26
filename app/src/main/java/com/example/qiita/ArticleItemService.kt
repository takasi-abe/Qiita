package com.example.qiita

import android.graphics.pdf.PdfDocument
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

class ArticleItemService {


    /**
     * Qiita APIで記事を新着順に取得するためのインターフェース
     * @Query page ページ番号
     * @Query per_page 1ページあたりの要素数
     */
    interface ArticleService {
        @GET("items")
        fun articles(
            @Query("page") page: Int,
            @Query("par_page") perPage: Int
        ): Call<List<ArticleItems>>
    }
}