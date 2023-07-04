package com.example.android_three_tab.ui.phone

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView.OnItemClickListener
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.android_three_tab.databinding.FragmentPhoneBinding
import com.example.android_three_tab.ui.dashboard.PhoneData
import com.google.android.material.floatingactionbutton.FloatingActionButton


class PhoneFragment : Fragment(), PhoneAdapter.OnItemClickListener {

    private var _binding: FragmentPhoneBinding? = null



    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!
    var tempIndexx: Int = 5
    private val dataList = mutableListOf(
        PhoneData("Jang", "010-1234-1234"),
        PhoneData("Song", "010-1241-1313"),
        PhoneData("LSLS", "010-1313-1313"),
        PhoneData("SSSS", "010-4142-4224"),
        PhoneData("ALSS", "010-1414-1414")
    )

    private lateinit var adapter: PhoneAdapter


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentPhoneBinding.inflate(inflater, container, false)
        val view = binding.root

        val dividerItemDecoration = DividerItemDecoration(binding.rcvPhone.context, LinearLayoutManager(requireContext()).orientation)
        binding.rcvPhone.addItemDecoration(dividerItemDecoration)

        adapter = PhoneAdapter(dataList as ArrayList<PhoneData>, this)
        binding.rcvPhone.layoutManager = LinearLayoutManager(requireContext())
        binding.rcvPhone.adapter = adapter



        val fab_btn: FloatingActionButton = binding.fabMain
        fab_btn.setOnClickListener {
            showAddPhoneDialog()
        }

        return view
    }
    private fun showAddPhoneDialog() {
        val dialog = AddPhoneDialog(object : AddPhoneDialog.AddPhoneDialogListener {
            override fun onPhoneAdded(name: String, phone: String) {
                val phoneData = PhoneData(name, phone)
                dataList.add(phoneData)
                adapter.notifyDataSetChanged()
            }
        })
        dialog.show(parentFragmentManager, "AddPhoneDialog")
    }

    override fun onItemClick(position:Int) {
        val item = dataList[position]
        val phoneN = item.phoneNum
        val dialIntent = Intent(Intent.ACTION_DIAL)
        dialIntent.data = Uri.parse("tel:$phoneN")
        startActivity(dialIntent)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}