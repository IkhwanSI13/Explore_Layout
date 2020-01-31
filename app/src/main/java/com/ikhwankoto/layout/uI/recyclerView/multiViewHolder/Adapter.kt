package com.ikhwankoto.layout.uI.recyclerView.multiViewHolder

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.ikhwankoto.layout.R

class Adapter(private val dataSet: ArrayList<SampleData>) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private var total_types: Int = 0

    class BannerTypeViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        internal var bannerImg: ImageView = itemView.findViewById(R.id.imgBanner)
    }

    class ImageTypeViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        internal var txtType: TextView = itemView.findViewById(R.id.txtTitle)
        internal var image: ImageView = itemView.findViewById(R.id.imageView) as ImageView
    }

    init {
        total_types = dataSet.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view: View
        when (viewType) {
            SampleData.TYPE_BANNER -> {
                view = LayoutInflater.from(parent.context)
                    .inflate(R.layout.banner_image, parent, false)

                val lp = view.layoutParams
                if (lp is StaggeredGridLayoutManager.LayoutParams) {
                    val sglp = lp as StaggeredGridLayoutManager.LayoutParams
                    sglp.isFullSpan = true
                }

                return BannerTypeViewHolder(view)
            }
            SampleData.TYPE_IMAGE_WITH_TEXT -> {
                view = LayoutInflater.from(parent.context)
                    .inflate(R.layout.image_with_title, parent, false)
                return ImageTypeViewHolder(view)
            }
        }

        //default
        view = LayoutInflater.from(parent.context)
            .inflate(R.layout.image_with_title, parent, false)
        return ImageTypeViewHolder(view)
    }

    override fun getItemViewType(position: Int): Int {
        when (dataSet[position].type) {
            0 -> return SampleData.TYPE_BANNER
            1 -> return SampleData.TYPE_IMAGE_WITH_TEXT
        }

        //default
        return SampleData.TYPE_IMAGE_WITH_TEXT
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, listPosition: Int) {
        val data = dataSet[listPosition]
        when (data.type) {
            SampleData.TYPE_BANNER -> {
                (holder as BannerTypeViewHolder).bannerImg.setBackgroundResource(R.drawable.ic_launcher_background)
            }
            SampleData.TYPE_IMAGE_WITH_TEXT -> {
                (holder as ImageTypeViewHolder).txtType.text = data.text
                holder.image.setImageResource(data.data)
            }
            SampleData.TYPE_IMAGE_WITH_TEXT2 -> {
                (holder as ImageTypeViewHolder).txtType.text = data.text
                holder.image.setImageResource(data.data)
            }
        }
    }

    override fun getItemCount(): Int = dataSet.size

}