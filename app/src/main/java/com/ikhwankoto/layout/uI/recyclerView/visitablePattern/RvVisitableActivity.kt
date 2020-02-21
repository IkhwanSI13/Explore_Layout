package com.ikhwankoto.layout.uI.recyclerView.visitablePattern

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.ikhwankoto.layout.R
import com.ikhwankoto.layout.uI.recyclerView.visitablePattern.base.BaseAdapter
import com.ikhwankoto.layout.uI.recyclerView.visitablePattern.entity.Data
import com.ikhwankoto.layout.uI.recyclerView.visitablePattern.entity.Menu
import com.ikhwankoto.layout.uI.recyclerView.visitablePattern.entity.VhData
import com.ikhwankoto.layout.uI.recyclerView.visitablePattern.entity.VhMenu
import com.ikhwankoto.layout.uI.recyclerView.visitablePattern.factory.ItemTypeFactoryImpl
import kotlinx.android.synthetic.main.activity_rv_visitable.*

class RvVisitableActivity : AppCompatActivity() {

    lateinit var adapter: BaseAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_rv_visitable)

        adapter = BaseAdapter(ItemTypeFactoryImpl())
        rv_visitable.layoutManager = LinearLayoutManager(this)
        rv_visitable.adapter = adapter

        overviewMenu()
        highLightItem()
    }

    private fun overviewMenu() {
        val overviewMenus = listOf(
            VhMenu(
                Menu(R.drawable.ic_email_black_24dp, "Email"),
                Menu(R.drawable.ic_share_black_24dp, "Share"),
                Menu(R.drawable.ic_link_black_24dp, "Link"),
                Menu(R.drawable.ic_content_copy_black_24dp, "Copy")
            )
        )
        adapter.addItem(overviewMenus)
    }

    private fun highLightItem() {
        val highlights = listOf(
            VhData(listOf(
                Data("Teknologi", "FlashDisk"),
                Data("Teknologi", "Hp"),
                Data("Teknologi", "Laptop"),
                Data("Makanan", "Nasi")
            ))
        )
        adapter.addItem(highlights)
    }


}
