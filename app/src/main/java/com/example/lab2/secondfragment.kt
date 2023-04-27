package com.example.lab2

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.example.animal.Animal_DataClass
import com.example.animal.CustomAdapter
import com.example.lab2.databinding.FragmentSecondfragmentBinding


class secondfragment : Fragment() {
    private var _binding : FragmentSecondfragmentBinding? = null
    private val binding get() = _binding!!
    companion object{
        val number = "number"
        val description = "description"
        val nameof = "nameof"
        val url = "url"
        val fulldescription = "fulldescription"
    }



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentSecondfragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.textViewName.text = arguments?.getString(nameof)
        binding.textViewDesk.text = arguments?.getString(description)
        binding.textViewFullDesk.text = arguments?.getString(fulldescription)
        Glide.with(view).load(arguments?.getString(url)).fitCenter().into(binding.imageView2)

    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}