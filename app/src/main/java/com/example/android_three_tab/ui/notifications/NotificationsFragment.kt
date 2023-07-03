package com.example.android_three_tab.ui.notifications

import android.app.appsearch.GlobalSearchSession
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.LinearLayout
import android.widget.ProgressBar
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.android_three_tab.R
// import androidx.lifecycle.ViewModelProvider
import com.example.android_three_tab.databinding.FragmentNotificationsBinding

const val BASE_URL1 = "https://cat-fact.herokuapp.com/"
const val BASE_URL2 = "https://api.qwer.pw"
class NotificationsFragment : Fragment() {

    private var _binding: FragmentNotificationsBinding? = null

    lateinit var myStringBuilder: java.lang.StringBuilder

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val notificationsViewModel =
            ViewModelProvider(this).get(NotificationsViewModel::class.java)

        _binding = FragmentNotificationsBinding.inflate(inflater, container, false)
        val root: View = binding.root
//        val textView: TextView = binding.textNotifications
//        notificationsViewModel.text.observe(viewLifecycleOwner) {
//            textView.text = it
//        }
        return root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        getCurrentData(view)
        view.findViewById<RelativeLayout>(R.id.layout_generate_new_fact)?.setOnClickListener {
            getCurrentData(view)
        }

        // Find the refresh button by ID
        val btnRefresh: Button = view.findViewById(R.id.btn_refresh)

        // Set the click listener for the refresh button
        btnRefresh.setOnClickListener {
            onRefreshClicked(view)
        }

        btnRefresh.visibility = View.INVISIBLE

//        layout_generate_new_fact.setOnClickListener {
//            getCurrentData()
//        }







        val textView: TextView = binding.textNotifications
        notificationsViewModel.text.observe(viewLifecycleOwner) {
            textView.text = it
        }

        // Make the initial API call
        makeApiCall()

//        api.getThingUn().enqueue(object : Callback<List<ThingJsonItem>> {
//            override fun onResponse(
//                call: Call<List<ThingJsonItem>>,
//                response: Response<List<ThingJsonItem>>
//            ) {
//                if (response.isSuccessful) {
//                    val thingJson = response.body()!!
//
//                    val result = thingJson[0].result
//                    val respond = thingJson[1].respond
//
//                    view.findViewById<TextView>(R.id.tv_textView).visibility = View.VISIBLE
//                    view.findViewById<TextView>(R.id.tv_timeStamp).visibility = View.VISIBLE
//                    view.findViewById<ProgressBar>(R.id.progressBar).visibility = View.GONE
//                    view.findViewById<TextView>(R.id.tv_textView).text = respond
//                    view.findViewById<TextView>(R.id.tv_timeStamp).text = result
//                }
//            }
//
//            override fun onFailure(call: Call<List<ThingJsonItem>>, t: Throwable) {
//                TODO("Not yet implemented")
//            }



    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}

//private fun <T> Call<T>.enqueue() {
//    fun onResponse(call: Call<List<ThingJsonItem>?>, response: Response<List<ThingJsonItem>?>){
//        val responseBody = response.body()!!
//
//        val myStringBuilder = StringBuilder()
//
//        for (myData in responseBody){
//            myStringBuilder.append(myData.respond)
//        }
//
//    }
//}

