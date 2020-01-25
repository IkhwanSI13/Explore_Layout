package com.ikhwankoto.layout

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.ikhwankoto.layout.UI.*
import com.ikhwankoto.layout.UI.ButtomSheet.ButtomSheetActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn_textinput.setOnClickListener {
            startActivity(Intent(this, TextInputActivity::class.java))
        }
        btn_buttomappbar.setOnClickListener {
            startActivity(Intent(this, ButtomAppBarActivity::class.java))
        }
        btn_buttomsheetbar.setOnClickListener {
            startActivity(Intent(this, ButtomSheetActivity::class.java))
        }
        btn_chip.setOnClickListener {
            startActivity(Intent(this, ChipActivity::class.java))
        }
        btn_materialbtn.setOnClickListener {
            startActivity(Intent(this, MaterialButtonActivity::class.java))
        }
        btn_ratingbar.setOnClickListener {
            startActivity(Intent(this, RatingBarActivity::class.java))
        }
    }
}
