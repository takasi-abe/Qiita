package com.example.qiita

import android.graphics.*
import android.util.Log
import com.squareup.picasso.Transformation

class RoundedTransformation : Transformation {
    override fun key(): String {
        return "RoundedTransformation"
    }

    override fun transform(source: Bitmap): Bitmap {
        Log.d("RoundedTransFormation", "transform")

        var width = source.width
        var height = source.height

        var bitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888)
        var canvas = Canvas(bitmap)
        var paint = Paint()
        var rectF = RectF(0f,0f, width.toFloat(), height.toFloat())

        paint.isAntiAlias = true
        paint.shader = BitmapShader(source, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP)


        canvas.drawRoundRect(rectF, 10f, 10f, paint)

        source.recycle()

        return bitmap
    }

}