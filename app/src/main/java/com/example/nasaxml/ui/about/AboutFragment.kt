package com.example.nasaxml.ui.about

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.nasaxml.databinding.FragmentAboutBinding

class AboutFragment : Fragment() {

    private var _binding: FragmentAboutBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val aboutViewModel =
            ViewModelProvider(this).get(AboutViewModel::class.java)

        _binding = FragmentAboutBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val names = listOf(
            "Hazem Tamer  01271669552",
            "Nour",
            "Asseam",
            "Nada Tafesh  01023134839",
            "Menna Shata  01014857938"
        )
        val textView: TextView = binding.t2
        aboutViewModel.text.observe(viewLifecycleOwner) {
            textView.text = "This app is designed to provide detailed information about marine organisms, marine environments, and environmental changes.\n" +
                    "\n" +
                    "Key Features:\n" +
                    "\n" +
                    "•Explore Marine Organisms:\n" +
                    "\n" +
                    " Offers information about various species, including images and scientific data.\n" +
                    "\n" +
                    "•Monitor Environmental Changes:\n" +
                    "\n" +
                    " Allows users to track the impacts of climate change on oceans.\n" +
                    "\n" +
                    "•Community Interaction:\n" +
                    "\n" +
                    " Enables users to share experiences and observations about marine life.\n" +
                    "\n" +
                    "•Education and Awareness:\n" +
                    "\n" +
                    " Includes educational resources to raise awareness about the importance of oceans."
        }


        // Update the TextView with names
        binding.t1.text = names.joinToString(separator = "\n")


        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}