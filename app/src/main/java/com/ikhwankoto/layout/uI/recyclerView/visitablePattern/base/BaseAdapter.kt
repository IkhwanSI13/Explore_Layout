package com.ikhwankoto.layout.uI.recyclerView.visitablePattern.base

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ikhwankoto.layout.uI.recyclerView.visitablePattern.factory.ItemTypeFactory
import java.util.*

class BaseAdapter(
    private val adapterTypeFactory: ItemTypeFactory,
    private val items: ArrayList<BaseItemModel> = arrayListOf()
): RecyclerView.Adapter<BaseViewHolder<BaseItemModel>>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<BaseItemModel> {
        val view = inflateItem(parent, viewType)
        return adapterTypeFactory.createViewHolder(view, viewType) as BaseViewHolder<BaseItemModel>
    }

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: BaseViewHolder<BaseItemModel>, position: Int) {
        holder.bind(items[position])
    }

    private fun inflateItem(viewGroup: ViewGroup, viewType: Int): View {
        return LayoutInflater.from(viewGroup.context).inflate(viewType, viewGroup, false)
    }

    override fun getItemViewType(position: Int): Int {
        return items[position].type(adapterTypeFactory)
    }

    fun addItem(items: List<BaseItemModel>) {
        this.items.addAll(items)
        notifyDataSetChanged()
    }

    fun removeItem(item: BaseItemModel) {
        this.items.remove(item)
        notifyDataSetChanged()
    }

}