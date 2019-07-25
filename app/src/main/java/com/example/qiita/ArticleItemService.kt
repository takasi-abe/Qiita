package com.example.qiita

import android.graphics.pdf.PdfDocument
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

class ArticleItemService {

    interface ItemService {
        @GET("items")
        fun items(
            @Query("page") page: Int,
            @Query("par_page") perPage: Int
        ): Call<List<ArticleItems>>
    }
}