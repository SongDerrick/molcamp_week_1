package com.example.android_three_tab.ui.home


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
// import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
// import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.android_three_tab.R
//import androidx.recyclerview.widget.LinearLayoutManager
//import androidx.recyclerview.widget.RecyclerView
//import com.example.android_three_tab.R
import com.example.android_three_tab.databinding.FragmentHomeBinding
import android.content.Intent
import android.widget.Toast
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.bumptech.glide.Glide


class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private lateinit var adapter: MyAdapter
    private lateinit var recyclerView: RecyclerView
    private lateinit var imageArrayList: ArrayList<Gallery>

    lateinit var imageId : Array<Int>

    val recyclerViewPool = RecyclerView.RecycledViewPool()

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val homeViewModel =
            ViewModelProvider(this).get(HomeViewModel::class.java)

        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root

//        val textView: TextView = binding.textHome
//        homeViewModel.text.observe(viewLifecycleOwner) {
//            textView.text = it
//        }
        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        dataInitialize()
        // val layoutManager = GridLayoutManager(context, 3)
        val layoutManager = StaggeredGridLayoutManager(3, StaggeredGridLayoutManager.VERTICAL)
        recyclerView = view.findViewById(R.id.recycler_view)
        recyclerView.layoutManager = layoutManager
        recyclerView.setHasFixedSize(true)
        adapter = MyAdapter(imageArrayList)
        recyclerView.adapter = adapter
        adapter.setOnItemClickListener(object : MyAdapter.onItemClickListener{
            override fun onItemClick(position: Int) {
                // Toast.makeText(requireContext(),"$position", Toast.LENGTH_SHORT).show()
                val intent = Intent(context, DetailedActivity::class.java)
                // Pass any necessary data to the DetailedActivity using extra
                intent.putExtra("position", imageArrayList[position].titleImage)
                context?.startActivity(intent)
            }
        })


    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun dataInitialize(){
        imageArrayList = arrayListOf<Gallery>()

        imageId = arrayOf(
            R.drawable.food_image,
            R.drawable.image_21,
            R.drawable.image_2,
            R.drawable.image_3,
            R.drawable.image_4,
            R.drawable.image_5,
            R.drawable.image_6,
            R.drawable.image_7,
            R.drawable.image_8,
            R.drawable.image_9,
            R.drawable.image_10,
            R.drawable.image_11,
            R.drawable.image_12,
            R.drawable.image_13,
            R.drawable.image_14,
            R.drawable.image_15,
            R.drawable.image_16,
            R.drawable.image_17,
            R.drawable.image_18,
            R.drawable.image_19,
            R.drawable.image_20,
            R.drawable.image_1


        )
        getUserData()



    }

    private fun getUserData(){
        for(i in imageId.indices){
            val images = Gallery(imageId[i])
            imageArrayList.add(images)
        }

        // recyclerView.adapter = MyAdapter(imageArrayList)
    }


}

