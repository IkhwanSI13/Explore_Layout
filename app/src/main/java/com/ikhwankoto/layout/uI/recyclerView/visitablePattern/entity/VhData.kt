package com.ikhwankoto.layout.uI.recyclerView.visitablePattern.entity

import com.ikhwankoto.layout.uI.recyclerView.visitablePattern.base.BaseItemModel
import com.ikhwankoto.layout.uI.recyclerView.visitablePattern.factory.ItemTypeFactory

data class VhData(
    val items: List<Data> = listOf()
) : BaseItemModel() {

    override fun type(typeFactory: ItemTypeFactory): Int {
        return typeFactory.type(this)
    }

}