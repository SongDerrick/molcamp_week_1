package com.example.android_three_tab.ui.phone

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.android_three_tab.databinding.RowPhoneBinding
import com.example.android_three_tab.ui.dashboard.PhoneData

class PhoneAdapter(val itemList: ArrayList<PhoneData>) :
    RecyclerView.Adapter<PhoneAdapter.PhoneViewHolder>() {

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



    class PhoneViewHolder(private val binding: RowPhoneBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(phoneData: PhoneData){
            binding.rowPhone.text = phoneData.phoneNum
            binding.rowName.text = phoneData.name
        }
    }

}
