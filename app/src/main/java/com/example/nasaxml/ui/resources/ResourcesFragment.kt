package com.example.nasaxml.ui.resources

import android.content.Intent
import android.net.Uri
import androidx.fragment.app.viewModels
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider
import com.example.nasaxml.R
import com.example.nasaxml.databinding.FragmentHomeBinding
import com.example.nasaxml.databinding.FragmentResourcesBinding
import com.example.nasaxml.ui.home.HomeViewModel

class ResourcesFragment : Fragment() {

    private var _binding: FragmentResourcesBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val resourcesViewModel =
            ViewModelProvider(this).get(ResourcesViewModel::class.java)

        _binding = FragmentResourcesBinding.inflate(inflater, container, false)
        val root: View = binding.root

        binding.TVFA.setOnClickListener {
            openWebPage("https://science.nasa.gov/toolkit/oceanworlds/")
        }

        binding.TVSA.setOnClickListener {
            openWebPage("https://www.nasa.gov/specials/ocean-worlds/")
        }

        binding.TVTA.setOnClickListener {
            openWebPage("https://oceanworlds.space/")
        }
        return root
    }
    private fun openWebPage(url: String) {
        val intent = Intent(Intent.ACTION_VIEW)
        intent.data = Uri.parse(url)
        startActivity(intent)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}