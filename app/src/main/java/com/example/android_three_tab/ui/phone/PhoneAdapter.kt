package com.example.android_three_tab.ui.phone

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.android_three_tab.databinding.RowPhoneBinding
import com.example.android_three_tab.ui.dashboard.PhoneData
import com.example.android_three_tab.ui.home.MyAdapter

class PhoneAdapter(private val itemList: ArrayList<PhoneData>, private var itemClickListener: OnItemClickListener) :
    RecyclerView.Adapter<PhoneAdapter.PhoneViewHolder>() {

    interface OnItemClickListener {
        fun onItemClick(position:Int)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PhoneViewHolder {
        val binding = RowPhoneBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return PhoneViewHolder(binding)
    }

    override fun onBindViewHolder(holder: PhoneViewHolder, position: Int) {
        val currentItem = itemList[position]
        holder.bind(currentItem)
    }

    override fun getItemCount(): Int {
        return itemList.size
    }



    inner class PhoneViewHolder(private val binding: RowPhoneBinding) : RecyclerView.ViewHolder(binding.root) {
        init {
            binding.callBtn.setOnClickListener{
                val position = absoluteAdapterPosition
                if(position !=RecyclerView.NO_POSITION){
                    itemClickListener.onItemClick(position)
                }
            }
        }

        fun bind(phoneData: PhoneData){
            binding.rowPhone.text = phoneData.phoneNum
            binding.rowName.text = phoneData.name
        }
    }

}
