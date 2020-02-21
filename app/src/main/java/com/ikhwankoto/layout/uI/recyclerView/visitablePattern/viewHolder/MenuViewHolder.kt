package com.ikhwankoto.layout.uI.recyclerView.visitablePattern.viewHolder

import android.view.View
import com.ikhwankoto.layout.R
import com.ikhwankoto.layout.uI.recyclerView.visitablePattern.base.BaseViewHolder
import com.ikhwankoto.layout.uI.recyclerView.visitablePattern.entity.Menu
import com.ikhwankoto.layout.uI.recyclerView.visitablePattern.entity.VhMenu
import kotlinx.android.synthetic.main.item_vh_menu.view.*

class MenuViewHolder(view: View) : BaseViewHolder<VhMenu>(view) {

    private val imgScan = view.imgScan
    private val txtTitleScan = view.txtTitleScan

    private val imgPay = view.imgPay
    private val txtTitlePay = view.txtTitlePay

    private val imgHistory = view.imgHistory
    private val txtTitleHistory = view.txtTitleHistory

    private val imgUser = view.imgUser
    private val txtTitleUser = view.txtTitleUser

    override fun bind(element: VhMenu) {
        setBtnScan(element.scan)
        setBtnPay(element.pay)
        setBtnHistory(element.history)
        setBtnUser(element.user)
    }

    private fun setBtnScan(scan: Menu) {
        imgScan.setImageResource(scan.icon)
        txtTitleScan.text = scan.title
    }

    private fun setBtnPay(pay: Menu) {
        imgPay.setImageResource(pay.icon)
        txtTitlePay.text = pay.title
    }

    private fun setBtnHistory(history: Menu) {
        imgHistory.setImageResource(history.icon)
        txtTitleHistory.text = history.title
    }

    private fun setBtnUser(user: Menu) {
        imgUser.setImageResource(user.icon)
        txtTitleUser.text = user.title
    }

    companion object {
        val LAYOUT = R.layout.item_vh_menu
    }

}