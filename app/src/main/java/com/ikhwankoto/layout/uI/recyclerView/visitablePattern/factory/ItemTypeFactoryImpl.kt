package com.ikhwankoto.layout.uI.recyclerView.visitablePattern.factory

import android.view.View
import com.ikhwankoto.layout.uI.recyclerView.visitablePattern.base.BaseViewHolder
import com.ikhwankoto.layout.uI.recyclerView.visitablePattern.entity.VhData
import com.ikhwankoto.layout.uI.recyclerView.visitablePattern.entity.VhMenu
import com.ikhwankoto.layout.uI.recyclerView.visitablePattern.viewHolder.DataViewHolder
import com.ikhwankoto.layout.uI.recyclerView.visitablePattern.viewHolder.MenuViewHolder

class ItemTypeFactoryImpl : ItemTypeFactory {

    override fun type(typeFactory: VhMenu): Int = MenuViewHolder.LAYOUT

    override fun type(typeFactory: VhData): Int = DataViewHolder.LAYOUT

    override fun createViewHolder(parent: View, type: Int): BaseViewHolder<*> {
        return when (type) {
            MenuViewHolder.LAYOUT -> MenuViewHolder(parent)
            DataViewHolder.LAYOUT -> DataViewHolder(parent)
            else -> createViewHolder(parent, type)
        }
    }

}