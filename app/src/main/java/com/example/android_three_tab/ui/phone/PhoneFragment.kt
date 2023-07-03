package com.example.android_three_tab.ui.phone

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.android_three_tab.databinding.FragmentPhoneBinding
import com.example.android_three_tab.ui.dashboard.PhoneData
import com.google.android.material.floatingactionbutton.FloatingActionButton


class PhoneFragment : Fragment() {

    private var _binding: FragmentPhoneBinding? = null



    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

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
//        val dashboardViewModel =
//            ViewModelProvider(this).get(DashboardViewModel::class.java)

        _binding = FragmentPhoneBinding.inflate(inflater, container, false)
        val view = binding.root

        adapter = PhoneAdapter(dataList as ArrayList<PhoneData>)
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


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }



}