package com.example.android_three_tab.ui.home

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.example.android_three_tab.R
import com.google.android.material.imageview.ShapeableImageView
import com.squareup.picasso.Picasso


class MyAdapter(private val imageList : ArrayList<Gallery>) :
    RecyclerView.Adapter<MyAdapter.MyViewHolder>() {

    private lateinit var mListener : onItemClickListener

    interface onItemClickListener{
        fun onItemClick(position : Int)

    }


    fun setOnItemClickListener(listener: onItemClickListener){
        mListener = listener

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.list_item,
            parent, false
        )
        return MyViewHolder(itemView, mListener)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentItem = imageList[position]
        val context = holder.itemView.context


        // holder.titleImage.setImageResource(currentItem.titleImage)
        Picasso.get()
            .load(currentItem.titleImage)
            .resize(800, 0)
            .onlyScaleDown()
            .into(holder.titleImage)



    }

    override fun getItemCount(): Int {
        return imageList.size
    }

    class MyViewHolder(itemView : View, listener: onItemClickListener) : RecyclerView.ViewHolder(itemView){
        val titleImage : ShapeableImageView = itemView.findViewById(R.id.title_image)

        init {

            itemView.setOnClickListener {
                listener.onItemClick(adapterPosition)
            }

        }
    }


}