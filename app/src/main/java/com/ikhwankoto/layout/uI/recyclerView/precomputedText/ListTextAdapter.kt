package com.ikhwankoto.layout.uI.recyclerView.precomputedText;

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.text.PrecomputedTextCompat
import androidx.core.widget.TextViewCompat
import androidx.recyclerview.widget.RecyclerView
import com.ikhwankoto.layout.R
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.list_item_text.*

class ListTextAdapter(
    private val items: MutableList<String>
) :
    RecyclerView.Adapter<ListTextAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder =
        ViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.list_item_text,
                parent,
                false
            )
        )

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindItem(position, items)
    }

    override fun getItemCount(): Int = items.size

    class ViewHolder(override val containerView: View) : RecyclerView.ViewHolder(containerView),
        LayoutContainer {
        fun bindItem(
            position: Int, list: MutableList<String>
        ) {
            val expensiveText = list[position]

            //normal text
//            tv_text.text = expensiveText

            //precomputed text
            val params: PrecomputedTextCompat.Params = TextViewCompat.getTextMetricsParams(tv_text)
            val precomputedText = PrecomputedTextCompat.create(expensiveText, params)
            TextViewCompat.setPrecomputedText(tv_text, precomputedText)

            //another
//            // resolve spans on worker thread to reduce load on UI thread
//            val expensiveSpanned = resolveIntoSpans(networkData.item.textData)
//
//            // pre-compute measurement work to reduce load on UI thread
//            val textParams: PrecomputedTextCompat.Params = // we’ll get to this
//            val precomputedText: PrecomputedTextCompat =
//                PrecomputedTextCompat.create(expensiveSpanned, params)
        }
    }

}