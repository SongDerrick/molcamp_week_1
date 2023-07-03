package com.example.android_three_tab.ui.phone


import android.app.Dialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.DialogFragment
import com.example.android_three_tab.databinding.BottomSheetBinding


class AddPhoneDialog(private val listener: AddPhoneDialogListener) : DialogFragment() {

    private var _binding: BottomSheetBinding? = null
    private val binding get() = _binding!!

    interface AddPhoneDialogListener {
        fun onPhoneAdded(name: String, phone: String)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = BottomSheetBinding.inflate(inflater, container, false)
        val view = binding.root

        val addButton: Button = binding.addbutton
        addButton.setOnClickListener {

            val name = binding.nametext.text.toString()
            val phone = binding.phonetext.text.toString()

            listener.onPhoneAdded(name, phone)
        }

        return view
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        return super.onCreateDialog(savedInstanceState).apply {
            setCanceledOnTouchOutside(false)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
