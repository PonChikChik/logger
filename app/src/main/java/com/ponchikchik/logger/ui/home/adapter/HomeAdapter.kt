package com.ponchikchik.logger.ui.home.adapter

import android.os.Build
import android.text.method.TextKeyListener.clear
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.recyclerview.widget.RecyclerView
import com.ponchikchik.logger.R
import com.ponchikchik.logger.di.model.Log
import kotlinx.android.synthetic.main.item_log_layout.view.*
import java.time.format.DateTimeFormatter
import java.util.*
import java.util.Collections.addAll

class HomeAdapter(private val logs: ArrayList<Log>, private val onPressListener: (traceId: UUID) -> Unit) : RecyclerView.Adapter<HomeAdapter.DataViewHolder>() {

    class DataViewHolder(itemView: View, private val onPressListener: (traceId: UUID) -> Unit) : RecyclerView.ViewHolder(itemView) {
        @RequiresApi(Build.VERSION_CODES.O)
        fun bind(log: Log) {
            itemView.apply {
                log_title.text = log.traceId.toString()
                log_date.text = log.createdAt.format(DateTimeFormatter.ISO_DATE)
                log_container.setOnClickListener {
                    onPressListener(log.traceId)
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DataViewHolder =
        DataViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_log_layout, parent, false), onPressListener)

    override fun getItemCount(): Int = logs.size

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onBindViewHolder(holder: DataViewHolder, position: Int) {
        holder.bind(logs[position])
    }

    fun addLogs(logs: List<Log>) {
        this.logs.apply {
            clear()
            addAll(logs)
        }
    }
}
