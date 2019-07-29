package com.example.qiita

import android.graphics.*
import android.util.Log
import com.squareup.picasso.Transformation

/**
 * アイコンの角を丸くする処理
 */
class RoundedTransformation : Transformation {
    override fun key(): String {
        return "RoundedTransformation"
    }

    override fun transform(source: Bitmap): Bitmap {


        //アイコンの辺の長さを取得
        val width = source.width
        val height = source.height

        //型となる画像を作成
        val bitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888)

        //処理をする対象の画像サイズを指定
        val rectF = RectF(0f,0f, width.toFloat(), height.toFloat())

        //Bitmapを引数にCanvasをインスタンス化
        val canvas = Canvas(bitmap)

        //処理の際の詳細を設定
        val paint = Paint()
        paint.isAntiAlias = true
        paint.shader = BitmapShader(source, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP)

        //画像の処理
        canvas.drawRoundRect(rectF, 10f, 10f, paint)
        source.recycle()

        return bitmap
    }

}