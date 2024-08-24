package com.example.nasa_api

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.bumptech.glide.Glide
import com.example.nasa_api.databinding.FragmentHomeBinding
import com.example.nasa_api.nasaapi.HomeViewModel
import com.squareup.picasso.Picasso

class HomeFragment : Fragment() {

    lateinit var binding: FragmentHomeBinding
    private val viewModel by viewModels<HomeViewModel>()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentHomeBinding.inflate(inflater, container, false)




        return binding.root

    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.progressBar.visibility = View.VISIBLE

        viewModel.imageOfDay.observe(viewLifecycleOwner){ImageOfTheDay->

            if (ImageOfTheDay == null) {

                binding.progressBar.visibility = View.VISIBLE

            } else {

                binding.progressBar.visibility = View.GONE



                Picasso.with(context).load(ImageOfTheDay.hdurl).into(binding.image);


//                binding.text.text=ImageOfTheDay.explanation
            }




        }
    }

        }