package com.ikhwankoto.layout.uI.recyclerView.multiViewHolder

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.ikhwankoto.layout.R
import kotlinx.android.synthetic.main.activity_multi_vh.*

class MultiVhActivity : AppCompatActivity() {

    private lateinit var datas: ArrayList<SampleData>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_multi_vh)

        datas = ArrayList()
        prepareData()

        val adapter = Adapter(datas)
        // LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, RecyclerView.VERTICAL, false);

        recyclerView.layoutManager =
            StaggeredGridLayoutManager(3, StaggeredGridLayoutManager.VERTICAL)
        recyclerView.itemAnimator = DefaultItemAnimator()
        recyclerView.adapter = adapter
    }

    private fun prepareData() {
        var data: SampleData?
        for (i in 0 until 36) {
            if (i == 6 || i == 13 || i == 26) {
                data =
                    SampleData(SampleData.TYPE_BANNER, "", R.drawable.ic_email_black_24dp)
                datas.add(data)
            } else if (i % 2 == 0) {
                data =
                    SampleData(
                        SampleData.TYPE_IMAGE_WITH_TEXT,
                        "Fungsi Email",
                        R.drawable.ic_email_black_24dp
                    )
                datas.add(data)
            } else {
                data =
                    SampleData(
                        SampleData.TYPE_IMAGE_WITH_TEXT2,
                        "Fungsi Share",
                        R.drawable.ic_share_black_24dp
                    )
                datas.add(data)
            }
        }
    }
}
