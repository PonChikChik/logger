package com.ponchikchik.logger.ui.log_detail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import com.ponchikchik.logger.R
import com.ponchikchik.logger.di.repository.ApiRepository
import com.ponchikchik.logger.ui.view_models.ViewModelFactory
import com.ponchikchik.logger.ui.view_models.AmwayLoggerViewModel
import com.ponchikchik.logger.utils.ApiHelper
import com.ponchikchik.logger.utils.ApiStatus.*
import kotlinx.android.synthetic.main.log_detail_fragment.*
import java.util.*

class LogDetailFragment : Fragment() {

    private lateinit var logDetailViewModel: AmwayLoggerViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        logDetailViewModel = ViewModelProviders.of(
            this,
            ViewModelFactory(ApiHelper(ApiRepository.amwayStartService))
        ).get(AmwayLoggerViewModel::class.java)

        return inflater.inflate(R.layout.log_detail_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        val traceId = arguments?.get("traceId") as String

        setupObservers(UUID.fromString(traceId))
    }

    private fun setupObservers(traceId: UUID) {
        logDetailViewModel.getLogByTraceId(traceId).observe(viewLifecycleOwner, {
            when (it.status) {
                SUCCESS -> {
                    trace_id_value.text = it.data?.traceId.toString()
                }
                ERROR -> {

                }
                LOADING -> {

                }
            }
        })
    }
}