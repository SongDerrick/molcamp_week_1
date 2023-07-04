package com.example.android_three_tab.ui.notifications

import android.app.appsearch.GlobalSearchSession
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.LinearLayout
import android.widget.ProgressBar
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.android_three_tab.R
// import androidx.lifecycle.ViewModelProvider
import com.example.android_three_tab.databinding.FragmentNotificationsBinding
import com.example.android_three_tab.ui.home.DetailedActivity
import com.example.android_three_tab.ui.home.MyAdapter
import com.example.android_three_tab.ui.notifications.api.ThingJson
import com.example.android_three_tab.ui.notifications.api.ThingJsonItem
import com.google.gson.JsonArray
import com.squareup.moshi.Moshi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import org.json.JSONArray
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.awaitResponse
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

const val BASE_URL1 = "https://cat-fact.herokuapp.com/"
const val BASE_URL2 = "https://api.qwer.pw"
class NotificationsFragment : Fragment() {

    private var _binding: FragmentNotificationsBinding? = null

    lateinit var myStringBuilder: java.lang.StringBuilder

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!
    private lateinit var notificationsViewModel: NotificationsViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
//        val notificationsViewModel =
//            ViewModelProvider(this).get(NotificationsViewModel::class.java)
        val context = requireContext()
        notificationsViewModel = NotificationsViewModel(context)


        _binding = FragmentNotificationsBinding.inflate(inflater, container, false)
        val root: View = binding.root
//        val textView: TextView = binding.textNotifications
//        notificationsViewModel.text.observe(viewLifecycleOwner) {
//            textView.text = it
//        }

        // Find the refresh button by ID
//        val btnRefresh: Button = root.findViewById(R.id.btn_refresh)
//
//        // Set the click listener for the refresh button
//        btnRefresh.setOnClickListener {
//            onRefreshClicked(root)


//        }

        return root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        (requireActivity() as AppCompatActivity).supportActionBar?.hide()

        // Find the refresh button by ID
//        val btnRefresh: Button = view.findViewById(R.id.btn_refresh)

        view.findViewById<RelativeLayout>(R.id.layout_generate_new_fact).setOnClickListener {
            getCurrentData(view)
        }

        getCurrentData(view)



        // Set the click listener for the refresh button
//        btnRefresh.setOnClickListener {
//            onRefreshClicked(view)
//        }

        // btnRefresh.visibility = View.VISIBLE

//        layout_generate_new_fact.setOnClickListener {
//            getCurrentData()
//        }







    }

    fun onRefreshClicked(view: View) {
        getCurrentData(view)
    }
    private fun getCurrentData(view: View){

        view.findViewById<TextView>(R.id.tv_textView)?.visibility = View.INVISIBLE
        view.findViewById<TextView>(R.id.tv_timeStamp)?.visibility = View.INVISIBLE
        view.findViewById<ProgressBar>(R.id.progressBar)?.visibility = View.VISIBLE

        var api = Retrofit.Builder()
            .baseUrl(BASE_URL2)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ApiRequest::class.java)
        val callback = object : Callback<List<ThingJsonItem>> {
            override fun onResponse(
                call: Call<List<ThingJsonItem>>,
                response: Response<List<ThingJsonItem>>
            ) {
                // ... Your existing code ...
                if (response.isSuccessful) {
                    val thingJson = response.body()!!
                    val delimiter = "[-–]"

                    val result = thingJson[0].result

                    val respond = thingJson[1].respond
                    val part1 = respond.substringBeforeLast("–").trim()
                    val part2 = respond.substringAfterLast("-").trim()

                    val parts = respond.split(Regex(delimiter), 3).map { it.trim() }
                    val part3 = if (parts.isNotEmpty()) parts[0] else ""
                    val part4 = if (parts.size > 1) parts[1] else ""

                    view.findViewById<TextView>(R.id.tv_textView).visibility = View.VISIBLE
                    view.findViewById<TextView>(R.id.tv_timeStamp).visibility = View.VISIBLE
                    view.findViewById<ProgressBar>(R.id.progressBar).visibility = View.GONE
                    view.findViewById<TextView>(R.id.tv_textView).text = part3
                    view.findViewById<TextView>(R.id.tv_timeStamp).text = part4
                    // Handle the successful response and update the UI

                }
            }

            override fun onFailure(call: Call<List<ThingJsonItem>>, t: Throwable) {
                // Handle the failure if needed
            }
        }
        // Function to make the API call
        fun makeApiCall() {
            api.getThingUn().enqueue(callback)
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

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            android.R.id.home -> {
                // Handle the button click event here
                startActivity(Intent(context, AnotherActivity::class.java))
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        (requireActivity() as AppCompatActivity).supportActionBar?.show()
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

