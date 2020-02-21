package com.ikhwankoto.layout.uI.recyclerView.visitablePattern.factory

import android.view.View
import com.ikhwankoto.layout.uI.recyclerView.visitablePattern.base.BaseViewHolder
import com.ikhwankoto.layout.uI.recyclerView.visitablePattern.entity.VhData
import com.ikhwankoto.layout.uI.recyclerView.visitablePattern.entity.VhMenu

interface ItemTypeFactory {
    fun type(typeFactory: VhData): Int
    fun type(typeFactory: VhMenu): Int

    fun createViewHolder(parent: View, type: Int): BaseViewHolder<*>
}