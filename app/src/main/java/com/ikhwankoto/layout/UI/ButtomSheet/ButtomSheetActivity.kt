package com.ikhwankoto.layout.UI.ButtomSheet

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.ikhwankoto.layout.R
import kotlinx.android.synthetic.main.activity_buttom_sheet.*

class ButtomSheetActivity : AppCompatActivity() {

//    lateinit var sheetBehavior: BottomSheetBehavior<>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_buttom_sheet)

        val sheetBehavior = BottomSheetBehavior.from(bottom_sheet)
        sheetBehavior.isHideable = false
        sheetBehavior.setBottomSheetCallback(object : BottomSheetBehavior.BottomSheetCallback() {
            override fun onSlide(p0: View, p1: Float) {

            }

            override fun onStateChanged(p0: View, newState: Int) {
                when (newState) {
                    BottomSheetBehavior.STATE_HIDDEN -> {
                    }
                    BottomSheetBehavior.STATE_EXPANDED -> {
                        btn_bottom_sheet.setText("Close Sheet")
                    }
                    BottomSheetBehavior.STATE_COLLAPSED -> {
                        btn_bottom_sheet.setText("Expand Sheet")
                    }
                    BottomSheetBehavior.STATE_DRAGGING -> {
                    }
                    BottomSheetBehavior.STATE_SETTLING -> {
                    }
                }
            }
        })

        btn_bottom_sheet.setOnClickListener {
            if (sheetBehavior.state !== BottomSheetBehavior.STATE_EXPANDED) {
                sheetBehavior.state = BottomSheetBehavior.STATE_EXPANDED
                btn_bottom_sheet.setText("Close sheet")
            } else {
                sheetBehavior.state = BottomSheetBehavior.STATE_COLLAPSED
                btn_bottom_sheet.setText("Expand sheet")
            }
        }

        btn_bottom_sheet_dialog.setOnClickListener {
            val view = layoutInflater.inflate(R.layout.fragment_buttom_sheet, null)

            val dialog = BottomSheetDialog(this)
            dialog.setContentView(view)
            dialog.show()
        }

        btn_bottom_sheet_dialog_fragment.setOnClickListener {
            val bottomSheetFragment = BottomSheetFragment()
            bottomSheetFragment.show(supportFragmentManager, bottomSheetFragment.tag)
        }
    }

}
