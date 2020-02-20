package com.ikhwankoto.layout.uI.customView

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.LinearLayout
import com.ikhwankoto.layout.R
import kotlinx.android.synthetic.main.widget_text_text_view.view.*

class TextTextView : LinearLayout {

    constructor(context: Context?) : super(context) {
        init()
    }

    constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs) {
        init()
    }

    private fun init() {
        LayoutInflater.from(context).inflate(R.layout.widget_text_text_view, this)
    }

    fun setText1(text: String) {
        text1TextView.text = text
    }

    fun setText2(text: String) {
        text2TextView.text = text
    }
}