package com.ponchikchik.logger.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import com.ponchikchik.logger.R
import com.ponchikchik.logger.di.repository.ApiRepository
import com.ponchikchik.logger.ui.ViewModelFactory
import com.ponchikchik.logger.utils.ApiHelper
import com.ponchikchik.logger.utils.ApiStatus.*

class HomeFragment : Fragment() {

    private lateinit var homeViewModel: HomeViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        homeViewModel =
            ViewModelProviders.of(
                this,
                ViewModelFactory(ApiHelper(ApiRepository.amwayStartService))
            )
                .get(HomeViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_home, container, false)
        val textView: TextView = root.findViewById(R.id.text_home)
        homeViewModel.text.observe(viewLifecycleOwner, {
            textView.text = it
        })

        setupObservers()

        return root
    }

    private fun setupObservers() {
        homeViewModel.getAllLogs().observe(viewLifecycleOwner, {
            when (it.status) {
                SUCCESS -> {
                    it.data
                }
                ERROR -> {

                }
                LOADING -> {

                }
            }
        })
    }
}