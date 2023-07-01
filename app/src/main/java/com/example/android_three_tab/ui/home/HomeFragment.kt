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


class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private lateinit var adapter: MyAdapter
    private lateinit var recyclerView: RecyclerView
    private lateinit var imageArrayList: ArrayList<Gallery>

    lateinit var imageId : Array<Int>

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
        val layoutManager = GridLayoutManager(context, 3)
        recyclerView = view.findViewById(R.id.recycler_view)
        recyclerView.layoutManager = layoutManager
        recyclerView.setHasFixedSize(true)
        adapter = MyAdapter(imageArrayList)
        recyclerView.adapter = adapter
        adapter.setOnItemClickListener(object : MyAdapter.onItemClickListener{
            override fun onItemClick(position: Int) {
                Toast.makeText(requireContext(),"$position", Toast.LENGTH_SHORT).show()
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
            R.drawable.dice_1,
            R.drawable.dice_2,
            R.drawable.dice_3,
            R.drawable.dice_4,
            R.drawable.dice_5,
            R.drawable.dice_6,
            R.drawable.dice_6,
            R.drawable.dice_6,
            R.drawable.dice_6,
            R.drawable.dice_6,
            R.drawable.dice_6,
            R.drawable.dice_6,
            R.drawable.dice_6,
            R.drawable.dice_6,
            R.drawable.dice_6,
            R.drawable.dice_6,
            R.drawable.dice_6,
            R.drawable.dice_6,
            R.drawable.dice_6,
            R.drawable.dice_6,
            R.drawable.ic_home_black_24dp
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

