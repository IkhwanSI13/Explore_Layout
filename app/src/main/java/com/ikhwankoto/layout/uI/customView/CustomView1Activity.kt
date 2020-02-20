package com.ikhwankoto.layout.uI.customView

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.ikhwankoto.layout.R
import kotlinx.android.synthetic.main.activity_custom_view1.*

//Custom view with style theme

class CustomView1Activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_custom_view1)

        textTextView.setText1("Primary text")
        textTextView.setText2("Secondary text")
    }
}
