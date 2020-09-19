package com.ikhwankoto.layout.uI.material

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import com.ikhwankoto.layout.R
import kotlinx.android.synthetic.main.activity_dialog.*

/**
 * https://github.com/material-components/material-components-android/blob/master/docs/components/Dialog.md#alert-dialog
 * todo dialog fragment
 * */
class DialogActivity : AppCompatActivity(), View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dialog)

        btn_alertDialog.setOnClickListener(this)
        btn_simpleDialog.setOnClickListener(this)
        btn_confirmationDialog.setOnClickListener(this)
        btn_confirmationDialog2.setOnClickListener(this)
    }

    override fun onClick(p0: View?) {
        p0?.let {
            when (p0.id) {
                R.id.btn_alertDialog ->
                    MaterialAlertDialogBuilder(this@DialogActivity)
                        .setTitle("Title")
                        .setMessage("supporting_text")
                        .setNeutralButton("cancel") { dialog, which ->
                            // Respond to neutral button press
                        }
                        .setNegativeButton("decline") { dialog, which ->
                            // Respond to negative button press
                        }
                        .setPositiveButton("accept") { dialog, which ->
                            // Respond to positive button press
                        }
                        .show()
                R.id.btn_simpleDialog -> {
                    val items = arrayOf("Item 1", "Item 2", "Item 3")

                    MaterialAlertDialogBuilder(this@DialogActivity)
                        .setTitle("Title")
                        .setItems(items) { dialog, which ->
                            // Respond to item chosen
                            Toast.makeText(this@DialogActivity, items[which], Toast.LENGTH_LONG)
                                .show()
                        }
                        .show()
                }
                R.id.btn_confirmationDialog -> {
                    val singleItems = arrayOf("Item 1", "Item 2", "Item 3")
                    val checkedItem = 1

                    MaterialAlertDialogBuilder(this@DialogActivity)
                        .setTitle("title")
                        .setNeutralButton("cancel") { dialog, which ->
                        }
                        .setPositiveButton("ok") { dialog, which ->
                        }
                        // Single-choice items (initialized with checked item)
                        .setSingleChoiceItems(singleItems, checkedItem) { dialog, which ->
                            // Respond to item chosen
                            Toast.makeText(
                                this@DialogActivity,
                                singleItems[which],
                                Toast.LENGTH_SHORT
                            )
                                .show()
                        }
                        .show()
                }
                R.id.btn_confirmationDialog2 -> {
                    val multiItems = arrayOf("Item 1", "Item 2", "Item 3")
                    val checkedItems = booleanArrayOf(true, false, false, false)

                    MaterialAlertDialogBuilder(this@DialogActivity)
                        .setTitle("title")
                        .setNeutralButton("cancel") { dialog, which ->
                        }
                        .setPositiveButton("ok") { dialog, which ->
                        }
                        //Multi-choice items (initialized with checked items)
                        .setMultiChoiceItems(multiItems, checkedItems) { dialog, which, checked ->
                            // Respond to item chosen
                            Log.e("Ikhwan", "checked:" + multiItems[which])
                            Log.e("Ikhwan", "checked:" + checkedItems[which])
                            Log.e("Ikhwan", "checked:" + checked)
                        }
                        .show()
                }
                else -> {
                }
            }
        }
    }

}
