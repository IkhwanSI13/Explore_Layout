package com.ikhwankoto.layout.uI.material

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.ikhwankoto.layout.R
import kotlinx.android.synthetic.main.activity_material_button.*

class MaterialButtonActivity : AppCompatActivity(), View.OnClickListener {

    /**
     * Note: <Button> is auto-inflated as <com.google.android.material.button.MaterialButton> via
     * MaterialComponentsViewInflater when using a non-Bridge Theme.MaterialComponents.* theme.
     * */

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_material_button)

        setUpToogleButton()
    }

    override fun onClick(p0: View?) {
        p0?.let {
            when (p0.id) {
                R.id.btn_standart -> {
                    Toast.makeText(this@MaterialButtonActivity, "Standart", Toast.LENGTH_SHORT)
                        .show()
                }
            }
        }
    }

    private fun setUpToogleButton() {
        toggleButton.addOnButtonCheckedListener { toggleButton, checkedId, isChecked ->
            when (checkedId) {
                R.id.toggleButton1 -> {
                    if (isChecked)
                        Toast.makeText(
                            this@MaterialButtonActivity,
                            "Btn 1 True",
                            Toast.LENGTH_SHORT
                        )
                            .show()
                    else
                        Toast.makeText(
                            this@MaterialButtonActivity,
                            "Btn 1 False",
                            Toast.LENGTH_SHORT
                        )
                            .show()
                }
                R.id.toggleButton2 -> {
                    if (isChecked)
                        Toast.makeText(
                            this@MaterialButtonActivity,
                            "Btn 2 True",
                            Toast.LENGTH_SHORT
                        )
                            .show()
                    else
                        Toast.makeText(
                            this@MaterialButtonActivity,
                            "Btn 2 False",
                            Toast.LENGTH_SHORT
                        )
                            .show()
                }
                R.id.toggleButton3 -> {
                    if (isChecked)
                        Toast.makeText(
                            this@MaterialButtonActivity,
                            "Btn 3 True",
                            Toast.LENGTH_SHORT
                        )
                            .show()
                    else
                        Toast.makeText(
                            this@MaterialButtonActivity,
                            "Btn 3 False",
                            Toast.LENGTH_SHORT
                        )
                            .show()
                }
            }
        }

    }

}
