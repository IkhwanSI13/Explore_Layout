package com.ikhwankoto.layout.uI.recyclerView.multiSelect

import android.content.Context
import android.util.SparseBooleanArray
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.ikhwankoto.layout.R
import com.ikhwankoto.layout.databinding.ListItemBinding
import java.util.*

class ListAdapter(private val mContext: Context, private val list: MutableList<Inbox>) :
    RecyclerView.Adapter<ListAdapter.ViewHolder>() {
    private val selectedItems: SparseBooleanArray = SparseBooleanArray()
    private var selectedIndex = -1
    private var itemClick: OnItemClick? = null

    fun setItemClick(itemClick: OnItemClick) {
        this.itemClick = itemClick
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val bi: ListItemBinding = DataBindingUtil.inflate(
            LayoutInflater.from(mContext),
            R.layout.list_item,
            parent,
            false
        )

        return ViewHolder(bi)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bi.from.text = list[position].from
        holder.bi.email.text = list[position].email
        holder.bi.imageLetter.text = list[position].from.substring(0, 1)
        holder.bi.date.text = list[position].date

        //Changes the activated state of this view.
        holder.bi.lytParent.isActivated = selectedItems.get(position, false)

        holder.bi.lytParent.setOnClickListener(View.OnClickListener { view ->
            if (itemClick == null) return@OnClickListener
            itemClick!!.onItemClick(view, list[position], position)
        })
        holder.bi.lytParent.setOnLongClickListener(View.OnLongClickListener { view ->
            if (itemClick == null) {
                false
            } else {
                itemClick!!.onLongPress(view, list[position], position)
                true
            }
        })
        toggleIcon(holder.bi, position)
    }

    override fun getItemCount(): Int = list.size

    /**
    This method will trigger when we we long press the item and it will change the icon
    of the item to check icon.*/
    private fun toggleIcon(bi: ListItemBinding, position: Int) {
        if (selectedItems.get(position, false)) {
            bi.lytImage.visibility = View.GONE
            bi.lytChecked.visibility = View.VISIBLE
            if (selectedIndex == position) selectedIndex = -1
        } else {
            bi.lytImage.visibility = View.VISIBLE
            bi.lytChecked.visibility = View.GONE
            if (selectedIndex == position) selectedIndex = -1
        }
    }

    /**This method helps you to get all selected items from the list*/
    fun getSelectedItems(): List<Int> {
        val items = ArrayList<Int>(selectedItems.size())
        for (i in 0 until selectedItems.size()) {
            items.add(selectedItems.keyAt(i))
        }
        return items
    }

    /**this will be used when we want to delete items from our list*/
    fun removeItems(position: Int) {
        list.removeAt(position)
        selectedIndex = -1

    }

    /**for clearing our selection*/
    fun clearSelection() {
        selectedItems.clear()
        notifyDataSetChanged()
    }

    /**this function will toggle the selection of items*/
    fun toggleSelection(position: Int) {
        selectedIndex = position
        if (selectedItems.get(position, false)) {
            selectedItems.delete(position)
        } else {
            selectedItems.put(position, true)
        }
        notifyItemChanged(position)
    }

    /**How many items have been selected? this method exactly the same . this will return a
     * total number of selected items.*/
    fun selectedItemCount(): Int = selectedItems.size()

    inner class ViewHolder(var bi: ListItemBinding) : RecyclerView.ViewHolder(bi.root)

    interface OnItemClick {
        fun onItemClick(view: View, inbox: Inbox, position: Int)

        fun onLongPress(view: View, inbox: Inbox, position: Int)
    }
}
