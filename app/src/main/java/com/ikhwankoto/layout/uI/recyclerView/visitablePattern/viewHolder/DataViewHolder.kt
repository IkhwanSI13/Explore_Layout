package com.ikhwankoto.layout.uI.recyclerView.visitablePattern.viewHolder

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.ikhwankoto.layout.R
import com.ikhwankoto.layout.uI.recyclerView.visitablePattern.base.BaseViewHolder
import com.ikhwankoto.layout.uI.recyclerView.visitablePattern.entity.Data
import com.ikhwankoto.layout.uI.recyclerView.visitablePattern.entity.VhData
import kotlinx.android.synthetic.main.item_data.view.*
import kotlinx.android.synthetic.main.item_vh_data.view.*

class DataViewHolder(view: View) : BaseViewHolder<VhData>(view) {

    private lateinit var adapter: HighLightAdapter
    private var lstHighlight = view.lstHighLight

    override fun bind(element: VhData) {
        adapter = HighLightAdapter(element.items)
        lstHighlight.layoutManager = LinearLayoutManager(
            itemView.context,
            LinearLayoutManager.HORIZONTAL,
            false
        )
        lstHighlight.adapter = adapter
    }

    class HighLightAdapter(
        private val items: List<Data>
    ) : RecyclerView.Adapter<HighLightAdapter.HighLightViewHolder>() {

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HighLightViewHolder {
            return HighLightViewHolder.inflate(parent)
        }

        override fun getItemCount(): Int = items.size

        override fun onBindViewHolder(holder: HighLightViewHolder, position: Int) {
            holder.bind(items[position])
        }

        class HighLightViewHolder(view: View) : RecyclerView.ViewHolder(view) {

            private val txtTitle = view.txtTitle
            private val txtTag = view.txtTag

            fun bind(highLight: Data) {
                txtTitle.text = highLight.title
                txtTag.text = highLight.tag
            }

            companion object {
                fun inflate(viewGroup: ViewGroup): HighLightViewHolder {
                    val view = LayoutInflater
                        .from(viewGroup.context)
                        .inflate(R.layout.item_data, viewGroup, false)
                    return HighLightViewHolder(view)
                }
            }

        }
    }

    companion object {
        val LAYOUT = R.layout.item_vh_data
    }

}