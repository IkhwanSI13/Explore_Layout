package com.ikhwankoto.layout.uI.recyclerView.visitablePattern.base

import com.ikhwankoto.layout.uI.recyclerView.visitablePattern.factory.ItemTypeFactory

abstract class BaseItemModel {
    abstract fun type(typeFactory: ItemTypeFactory): Int
}