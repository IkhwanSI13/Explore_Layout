package com.ikhwankoto.layout.uI.recyclerView.precomputedText

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.ikhwankoto.layout.R
import kotlinx.android.synthetic.main.activity_rv_precomputed_text.*
import java.util.*

class RvPrecomputedTextActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_rv_precomputed_text)

        val adapter = ListTextAdapter(getData())

        rv_precomputed.layoutManager = LinearLayoutManager(this)
        rv_precomputed.setHasFixedSize(true)
        rv_precomputed.adapter = adapter
    }

    private fun getData(): MutableList<String> {
        val data = mutableListOf<String>()

        data.add(getRandomString(200))
        data.add(getRandomString(300))
        data.add(getRandomString(250))
        data.add(getRandomString(230))
        data.add(getRandomString(290))
        data.add(getRandomString(220))
        data.add(getRandomString(200))
        data.add(getRandomString(280))
        data.add(getRandomString(200))
        data.add(getRandomString(220))
        data.add(getRandomString(210))
        data.add(getRandomString(265))
        data.add(getRandomString(212))
        data.add(getRandomString(245))
        data.add(getRandomString(273))
        data.add(getRandomString(252))
        data.add(getRandomString(282))
        data.add(getRandomString(228))
        data.add(getRandomString(218))
        data.add(getRandomString(150))
        data.add(getRandomString(320))

        return data
    }


    var ALLOWED_CHARACTERS = "0123456789qwertyuiopasdfghjklzxcvbnm";
    private fun getRandomString(sizeOfRandomString: Int): String {
        val random = Random()
        val sb = StringBuilder(sizeOfRandomString)
        for (i in 0 until sizeOfRandomString)
            sb.append(ALLOWED_CHARACTERS[random.nextInt(ALLOWED_CHARACTERS.length)])
        return sb.toString()
    }
}
