package com.ikhwankoto.layout.UI

import android.os.Bundle
import com.google.android.material.textfield.TextInputLayout
import androidx.appcompat.app.AppCompatActivity
import com.ikhwankoto.layout.R
import kotlinx.android.synthetic.main.activity_textinput.*

class TextInputActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_textinput)

        btn.setOnClickListener {
            setErrorTextInputLayout(til_one)
            setErrorTextInputLayout(til_two)
        }

        btn_clear.setOnClickListener {
            clearError(til_one)
            clearError(til_two)
        }
    }

    fun setErrorTextInputLayout(til: TextInputLayout) {
        til.error = "Something Wrong"
    }

    fun clearError(til: TextInputLayout) {
        til.error = null
    }

}
