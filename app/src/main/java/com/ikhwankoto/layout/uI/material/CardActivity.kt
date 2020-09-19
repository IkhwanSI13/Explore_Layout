package com.ikhwankoto.layout.uI.material

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.ikhwankoto.layout.R
import kotlinx.android.synthetic.main.activity_card.*

class CardActivity : AppCompatActivity() {

    /**
     * todo
     * an app:state_dragged, card dragged
     * */

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_card)

        card_1.setOnLongClickListener {
            card_1.isChecked = !card_1.isChecked
            true
        }
    }
}
