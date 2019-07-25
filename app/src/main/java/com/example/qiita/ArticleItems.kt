package com.example.qiita

import com.squareup.moshi.Json

data class ArticleItems (
    @Json(name = "id") // 記事ID
    val id: String,

    @Json(name = "title") // タイトル
    val title: String,

    @Json(name = "created_at") //記事が作成された日
    val date: String,

    @Json(name = "user") // 記事の著者
    val user: User


)

data class User(
    @Json(name = "id") //ユーザーID
    val userId: String,

    @Json(name = "name") //ユーザー名(ユーザーが設定した名前)
    val userName: String,

    @Json(name = "profile_image_url") //ユーザーが設定したアイコン画像のURL
    val icon: String
)
