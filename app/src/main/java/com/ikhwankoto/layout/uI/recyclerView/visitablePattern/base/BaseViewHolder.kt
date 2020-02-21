package com.ikhwankoto.layout.uI.recyclerView.visitablePattern.base

import android.view.View
import androidx.recyclerview.widget.RecyclerView

abstract class BaseViewHolder<in T>(
    private val view: View
): RecyclerView.ViewHolder(view) {

    abstract fun bind(element: T)

}