package com.ikhwankoto.layout.uI.recyclerView.multiSelect

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Toast

import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.view.ActionMode
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager

import com.ikhwankoto.layout.R
import com.ikhwankoto.layout.databinding.ActivityRvMultiSelectBinding

class RvMultiSelectActivity : AppCompatActivity() {

    lateinit var bi: ActivityRvMultiSelectBinding
    lateinit var list: MutableList<Inbox>
    lateinit var adapter: ListAdapter
    var actionMode: ActionMode? = null
    lateinit var actionCallback: ActionCallback

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        bi = DataBindingUtil.setContentView(this, R.layout.activity_rv_multi_select)
        setSupportActionBar(bi.toolbar)
        supportActionBar!!.setTitle("Inbox")

        init()
    }

    private fun init() {
        actionCallback = ActionCallback()
        list = Util.getInboxData(this)
        list.addAll(Util.getInboxData(this))
        adapter = ListAdapter(this, list)
        bi.emailList.setLayoutManager(LinearLayoutManager(this))
        bi.emailList.setHasFixedSize(true)
        bi.emailList.setAdapter(adapter)
        adapter.setItemClick(object : ListAdapter.OnItemClick {
            override fun onItemClick(view: View, inbox: Inbox, position: Int) {
                if (adapter.selectedItemCount() > 0) {
                    toggleActionBar(position)
                } else {
                    Toast.makeText(
                        this@RvMultiSelectActivity,
                        "clicked " + inbox.from,
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }

            override fun onLongPress(view: View, inbox: Inbox, position: Int) {
                toggleActionBar(position)
            }
        })
    }

    /**toggling action bar that will change the color and option*/
    private fun toggleActionBar(position: Int) {
        if (actionMode == null) {
            actionMode = startSupportActionMode(actionCallback)
        }
        toggleSelection(position)
    }

    /**toggle selection of items and show the count of selected items on the action bar*/
    private fun toggleSelection(position: Int) {
        adapter.toggleSelection(position)
        val count = adapter.selectedItemCount()
        if (count == 0) {
            actionMode!!.finish()
        } else {
            actionMode!!.title = count.toString()
            actionMode!!.invalidate()
        }
    }

    /**after selection, we need to delete selected items by tapping on delete icon*/
    private fun deleteInbox() {
        val selectedItemPositions = adapter.getSelectedItems()
        for (i in selectedItemPositions.indices.reversed()) {
            adapter.removeItems(selectedItemPositions[i])
        }
        adapter.notifyDataSetChanged()
    }

    inner class ActionCallback : ActionMode.Callback {
        override fun onCreateActionMode(mode: ActionMode, menu: Menu): Boolean {
            Util.toggleStatusBarColor(this@RvMultiSelectActivity, R.color.colorAccent)
            mode.menuInflater.inflate(R.menu.menu, menu)
            return true
        }

        override fun onPrepareActionMode(mode: ActionMode, menu: Menu): Boolean {
            return false
        }

        override fun onActionItemClicked(mode: ActionMode, item: MenuItem): Boolean {
            when (item.itemId) {
                R.id.delteItem -> {
                    deleteInbox()
                    mode.finish()
                    return true
                }
            }
            return false
        }

        override fun onDestroyActionMode(mode: ActionMode) {
            adapter.clearSelection()
            actionMode = null
            Util.toggleStatusBarColor(this@RvMultiSelectActivity, R.color.colorPrimary)
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.search_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home) {
            finish()
        } else {
            Toast.makeText(applicationContext, item.title, Toast.LENGTH_SHORT).show()
        }
        return super.onOptionsItemSelected(item)
    }

}