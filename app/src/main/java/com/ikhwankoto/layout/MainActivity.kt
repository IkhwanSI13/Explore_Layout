package com.ikhwankoto.layout

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.ikhwankoto.layout.uI.*
import com.ikhwankoto.layout.uI.buttomSheet.ButtomSheetActivity
import com.ikhwankoto.layout.uI.recyclerView.multiSelect.RvMultiSelectActivity
import com.ikhwankoto.layout.uI.recyclerView.multiViewHolder.MultiVhActivity
import com.ikhwankoto.layout.uI.recyclerView.precomputedText.RvPrecomputedTextActivity
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
        btn_rv_multiselect.setOnClickListener {
            startActivity(Intent(this, RvMultiSelectActivity::class.java))
        }
        btn_rv_multivh.setOnClickListener {
            startActivity(Intent(this, MultiVhActivity::class.java))
        }
        btn_rv_precomputed_text.setOnClickListener {
            startActivity(Intent(this, RvPrecomputedTextActivity::class.java))
        }
        btn_tv.setOnClickListener {
            startActivity(Intent(this, TextViewActivity::class.java))
        }
    }
}
