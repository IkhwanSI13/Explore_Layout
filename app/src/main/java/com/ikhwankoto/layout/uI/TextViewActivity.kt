package com.ikhwankoto.layout.uI

import android.graphics.Color
import android.graphics.LinearGradient
import android.graphics.Shader
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.ikhwankoto.layout.R
import kotlinx.android.synthetic.main.activity_text_view.*
import java.util.*

class TextViewActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_text_view)

        val textShader = LinearGradient(
            0f, 0f, 0f, 50f,
            intArrayOf(Color.GREEN, Color.BLUE),
            floatArrayOf(0f, 1f), Shader.TileMode.CLAMP
        )
        tv_gradient.paint.shader = textShader
        tv_gradient.text = getRandomString(48)
    }

    var ALLOWED_CHARACTERS = "0123456789qwertyuiopasdfghjklzxcvbnm"
    private fun getRandomString(sizeOfRandomString: Int): String {
        val random = Random()
        val sb = StringBuilder(sizeOfRandomString)
        for (i in 0 until sizeOfRandomString)
            sb.append(ALLOWED_CHARACTERS[random.nextInt(ALLOWED_CHARACTERS.length)])
        return sb.toString()
    }

}
