package com.ikhwankoto.layout.uI.material

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.chip.Chip
import com.ikhwankoto.layout.R
import kotlinx.android.synthetic.main.activity_chip.*

class ChipActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_chip)

        //CHIP ENTRY
        chip_entry.setOnCheckedChangeListener { compuntBtn, state ->
            if (state)
                Toast.makeText(this, "Checked", Toast.LENGTH_SHORT).show()
            else
                Toast.makeText(this, "Unchecked", Toast.LENGTH_SHORT).show()
        }
        chip_entry.setOnCloseIconClickListener {
            Toast.makeText(this, "Close button clicked", Toast.LENGTH_SHORT).show()
        }

        //CHIP_FILTER
        chip_filter.setOnCheckedChangeListener { compuntBtn, state ->
            if (state)
                Toast.makeText(this, "Checked", Toast.LENGTH_SHORT).show()
            else
                Toast.makeText(this, "Unchecked", Toast.LENGTH_SHORT).show()
        }

        //CHIP_CHOICE
        chip_choice.setOnCheckedChangeListener { compuntBtn, state ->
            if (state)
                Toast.makeText(this, "Checked", Toast.LENGTH_SHORT).show()
            else
                Toast.makeText(this, "Unchecked", Toast.LENGTH_SHORT).show()
        }

        //CHIP_ACTION
        chip_action.setOnClickListener {
            Toast.makeText(this, "Clicked", Toast.LENGTH_SHORT).show()
        }

        //CHIP_GROUP
        //setOnCheckChange only work, if chipGroup singleSelectrion is true
        chip_group.setOnCheckedChangeListener { chipGroup, id ->
            when (id) {
                R.id.chip_choice1 -> Toast.makeText(this, chip_choice1.text, Toast.LENGTH_SHORT).show()
                R.id.chip_choice2 -> Toast.makeText(this, chip_choice2.text, Toast.LENGTH_SHORT).show()
                R.id.chip_choice3 -> Toast.makeText(this, chip_choice3.text, Toast.LENGTH_SHORT).show()
                R.id.chip_choice4 -> Toast.makeText(this, chip_choice4.text, Toast.LENGTH_SHORT).show()
            }
        }

        chip_group_horizontal.setOnCheckedChangeListener { chipGroup, id ->
            chipGroup.findViewById<Chip>(id)?.let { chip ->
                Toast.makeText(this, chip.text, Toast.LENGTH_SHORT).show()
            }
        }
    }
}
