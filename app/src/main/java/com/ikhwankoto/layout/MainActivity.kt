package com.ikhwankoto.layout

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.ikhwankoto.layout.uI.RatingBarActivity
import com.ikhwankoto.layout.uI.TextViewActivity
import com.ikhwankoto.layout.uI.customView.CustomView1Activity
import com.ikhwankoto.layout.uI.material.*
import com.ikhwankoto.layout.uI.material.bottomNavigation.BottomNavigationActivity
import com.ikhwankoto.layout.uI.material.buttomSheet.ButtomSheetActivity
import com.ikhwankoto.layout.uI.recyclerView.multiSelect.RvMultiSelectActivity
import com.ikhwankoto.layout.uI.recyclerView.multiViewHolder.MultiVhActivity
import com.ikhwankoto.layout.uI.recyclerView.precomputedText.RvPrecomputedTextActivity
import com.ikhwankoto.layout.uI.recyclerView.visitablePattern.RvVisitableActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), View.OnClickListener {

    //https://github.com/material-components/material-components-android/tree/master/docs/components
    //https://github.com/material-components/material-components-android/tree/master/catalog/java/io/material/catalog

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        /**
         * Material
         * */
        btn_buttomappbar.setOnClickListener(this)
        btn_buttomsheetbar.setOnClickListener(this)
        btn_materialbtn.setOnClickListener(this)
        btn_card.setOnClickListener(this)
        btn_checkbox.setOnClickListener(this)
        btn_chip.setOnClickListener(this)
        btn_collapsingToolbar.setOnClickListener(this)
        btn_dialog.setOnClickListener(this)
        btn_fab.setOnClickListener(this)
        btn_textinput.setOnClickListener(this)
        btn_bottomNavigation.setOnClickListener(this)

        /**
         * RecyclerView
         * */
        btn_rv_multiselect.setOnClickListener(this)
        btn_rv_precomputed_text.setOnClickListener(this)
        btn_rv_visittable.setOnClickListener(this)
        btn_rv_multivh.setOnClickListener(this)

        /**
         * Others
         * */
        btn_tv.setOnClickListener(this)
        btn_customview_style.setOnClickListener(this)
        btn_ratingbar.setOnClickListener(this)
    }

    private fun startAct(cls: Class<*>) {
        startActivity(
            Intent(
                this,
                cls
            )
        )
    }

    override fun onClick(p0: View?) {
        p0?.let {
            when (p0.id) {
                R.id.btn_buttomappbar -> startAct(ButtomAppBarActivity::class.java)
                R.id.btn_buttomsheetbar -> startAct(ButtomSheetActivity::class.java)
                R.id.btn_card -> startAct(CardActivity::class.java)
                R.id.btn_checkbox -> startAct(CheckboxActivity::class.java)
                R.id.btn_chip -> startAct(ChipActivity::class.java)
                R.id.btn_collapsingToolbar -> startAct(CollapsingToolbarActivity::class.java)
                R.id.btn_dialog -> startAct(DialogActivity::class.java)
                R.id.btn_fab -> startAct(FabActivity::class.java)
                R.id.btn_materialbtn -> startAct(MaterialButtonActivity::class.java)
                R.id.btn_textinput -> startAct(TextInputActivity::class.java)
                R.id.btn_bottomNavigation -> startAct(
                    BottomNavigationActivity::class.java
                )
                R.id.btn_rv_multiselect -> startAct(RvMultiSelectActivity::class.java)
                R.id.btn_rv_precomputed_text -> startAct(RvPrecomputedTextActivity::class.java)
                R.id.btn_rv_visittable -> startAct(RvVisitableActivity::class.java)
                R.id.btn_rv_multivh -> startAct(MultiVhActivity::class.java)
                R.id.btn_tv -> startAct(TextViewActivity::class.java)
                R.id.btn_customview_style -> startAct(CustomView1Activity::class.java)
                R.id.btn_ratingbar -> startAct(RatingBarActivity::class.java)
            }
        }
    }

}
