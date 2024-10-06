package com.example.nasaxml.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.nasaxml.R
import com.example.nasaxml.databinding.FragmentArticlesBinding
import com.example.nasaxml.databinding.FragmentHomeBinding
import com.example.nasaxml.ui.articles.ArticlesViewModel

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!
    private lateinit var recyclerView: RecyclerView
    private lateinit var animalsAdapter: AnimalsAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val homeViewModel = ViewModelProvider(this).get(HomeViewModel::class.java)
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val textView: TextView = binding.textHome
        homeViewModel.text.observe(viewLifecycleOwner) {
            textView.text = it
        }
        // Set up the RecyclerView
        recyclerView = binding.recyclerView
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        val animals = listOf(
            Animal(R.drawable.photo_2024_10_06_13_06_54, R.string.jupter, R.string.desJupter),
            Animal(R.drawable.ganymede, R.string.genymade, R.string.ganymede_is_the_largest_moon),
            Animal(R.drawable.photo_2024_10_06_12_18_43, R.string.hydro, R.string.hydrodeas),
            Animal(R.drawable.photo_2024_10_06_13_23_37, R.string.BiolOcean, R.string.BiolDisc),

        )

        animalsAdapter = AnimalsAdapter(animals)
        recyclerView.adapter = animalsAdapter

        // Add a click listener to navigate to ResourcesFragment
        binding.textHome.setOnClickListener {
            findNavController().navigate(R.id.action_home_to_resources)
        }

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}