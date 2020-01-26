package com.ikhwankoto.layout.uI

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.ikhwankoto.layout.R
import kotlinx.android.synthetic.main.activity_buttom_app_bar.*

class ButtomAppBarActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_buttom_app_bar)

        fab.setOnClickListener {
            Toast.makeText(this, "FAB clicked", Toast.LENGTH_SHORT).show()
        }

        setSupportActionBar(bar)
//        supportActionBar?.setDisplayHomeAsUpEnabled(true)
//        supportActionBar?.setDisplayShowHomeEnabled(true)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {

        item?.itemId?.let { id ->
            if (id == R.id.menu1) {
                Toast.makeText(this, "Menu 1 clicked", Toast.LENGTH_SHORT).show()
                return true
            } else if (id == R.id.menu2) {
                Toast.makeText(this, "Menu 2 clicked", Toast.LENGTH_SHORT).show()
                return true
            } else if (id == R.id.menu3) {
                Toast.makeText(this, "Menu 3 clicked", Toast.LENGTH_SHORT).show()
                return true
            }
        }

        return super.onOptionsItemSelected(item)
    }

}
