package com.ikhwankoto.layout.uI.recyclerView.multiSelect

import android.app.Activity
import android.content.Context
import android.view.WindowManager
import com.ikhwankoto.layout.R
import java.util.*

class Util {

    companion object {
        fun getInboxData(ctx: Context): MutableList<Inbox> {
            val items: MutableList<Inbox> = mutableListOf()
            //val drw_arr = ctx.resources.obtainTypedArray(R.array.people_images)
            val name_arr = ctx.resources.getStringArray(R.array.people_names)
            val date_arr = ctx.resources.getStringArray(R.array.general_date)

            for (element in name_arr) {
                val obj = Inbox(
                    element,
                    "abc@gmail.com",
                    "message message lorem",
                    date_arr[randInt(date_arr.size - 1)]
                )
                items.add(obj)
            }
            items.shuffle()
            return items
        }

        fun randInt(max: Int): Int {
            val r = Random()
            val min = 0
            return r.nextInt(max - min + 1) + min
        }

        /*
          this will toggle or action bar color
         */
        fun toggleStatusBarColor(activity: Activity, color: Int) {
            val window = activity.window
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS)
            //Min sdk 21
            //window.statusBarColor = activity.resources.getColor(R.color.colorPrimary)
        }
    }

}