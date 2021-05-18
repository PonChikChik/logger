package com.ponchikchik.logger.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.View.GONE
import android.view.View.VISIBLE
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.fragment.findNavController
import androidx.navigation.navOptions
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.ponchikchik.logger.R
import com.ponchikchik.logger.di.repository.ApiRepository
import com.ponchikchik.logger.ui.view_models.ViewModelFactory
import com.ponchikchik.logger.ui.home.adapter.HomeAdapter
import com.ponchikchik.logger.ui.view_models.AmwayLoggerViewModel
import com.ponchikchik.logger.utils.ApiHelper
import com.ponchikchik.logger.utils.ApiStatus.*
import kotlinx.android.synthetic.main.fragment_home.*
import java.util.*

class HomeFragment : Fragment() {

    private lateinit var amwayLoggerViewModel: AmwayLoggerViewModel
    private lateinit var adapter: HomeAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        amwayLoggerViewModel =
            ViewModelProviders.of(
                this,
                ViewModelFactory(ApiHelper(ApiRepository.amwayStartService))
            )
                .get(AmwayLoggerViewModel::class.java)

        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        setupUI()
        setupObservers()
    }

    private fun setupUI() {
        recyclerView.layoutManager = LinearLayoutManager(this.context)
        adapter = HomeAdapter(
            arrayListOf(),
            onPressListener = {
                onPressListener(it)
            }
        )
        recyclerView.addItemDecoration(
            DividerItemDecoration(
                recyclerView.context,
                (recyclerView.layoutManager as LinearLayoutManager).orientation
            )
        )

        recyclerView.adapter = adapter
    }

    private fun setupObservers() {
        amwayLoggerViewModel.getAllLogs().observe(viewLifecycleOwner, {
            when (it.status) {
                SUCCESS -> {
                    recyclerView.visibility = VISIBLE
                    progressBar.visibility = GONE
                    it.data?.let { logs ->
                        adapter.apply {
                            addLogs(logs)
                            notifyDataSetChanged()
                        }
                    }
                }
                ERROR -> {
                    recyclerView.visibility = VISIBLE
                    progressBar.visibility = GONE
                    Toast.makeText(this.context, it.message, Toast.LENGTH_LONG).show()
                }
                LOADING -> {
                    progressBar.visibility = VISIBLE
                    recyclerView.visibility = GONE
                }
            }
        })
    }

    private fun onPressListener(traceId: UUID) {
        val bundle = Bundle()
        bundle.putString("traceId", traceId.toString())

        findNavController().navigate(
            R.id.logDetailFragment,
            bundle,
            navOptions {
                anim {
                    enter = android.R.animator.fade_in
                    exit = android.R.animator.fade_out
                }
            }
        )
    }
}