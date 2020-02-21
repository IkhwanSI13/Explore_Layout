package com.ikhwankoto.layout.uI.recyclerView.visitablePattern.entity

import com.ikhwankoto.layout.uI.recyclerView.visitablePattern.base.BaseItemModel
import com.ikhwankoto.layout.uI.recyclerView.visitablePattern.factory.ItemTypeFactory

data class VhMenu(
    val scan: Menu,
    val pay: Menu,
    val history: Menu,
    val user: Menu
) : BaseItemModel() {

    override fun type(typeFactory: ItemTypeFactory): Int {
        return typeFactory.type(this)
    }

}