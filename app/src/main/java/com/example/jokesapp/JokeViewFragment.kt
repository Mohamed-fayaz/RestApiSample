package com.example.jokesapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.jokesapp.databinding.FragmentJokeViewBinding


class JokeViewFragment : Fragment() {
    private val viewModel: JokeViewModel by lazy {
        ViewModelProvider(this).get(JokeViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentJokeViewBinding.inflate(inflater)
        // Allows Data Binding to Observe LiveData with the lifecycle of this Fragment
        binding.lifecycleOwner = this

        // Giving the binding access to the OverviewViewModel
        binding.viewModel = viewModel
        val jokerv = binding.Jokerv
        jokerv.layoutManager = LinearLayoutManager(context)
        val adapter =JokeRvAdapter()
        jokerv.adapter = adapter
        viewModel.properties.observe(viewLifecycleOwner, Observer{

adapter.submitList(it)
        })

        return binding.root


    }


}