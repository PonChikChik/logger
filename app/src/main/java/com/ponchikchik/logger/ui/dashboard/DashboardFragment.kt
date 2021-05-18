package com.ponchikchik.logger.ui.dashboard

import android.graphics.Bitmap
import android.graphics.Canvas
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.View.SYSTEM_UI_FLAG_FULLSCREEN
import android.view.ViewGroup
import androidx.core.content.res.ResourcesCompat
import androidx.fragment.app.Fragment
import com.ponchikchik.logger.R
import com.ponchikchik.logger.ui.custom_views.PaintView

class DashboardFragment : Fragment() {

    private lateinit var extraCanvas: Canvas
    private lateinit var extraBitmap: Bitmap
    private val backgroundColor = ResourcesCompat.getColor(resources, R.color.white, null)

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        activity?.let {
            val canvasView = PaintView(it.applicationContext)
            canvasView.systemUiVisibility = SYSTEM_UI_FLAG_FULLSCREEN
            it.setContentView(canvasView)
        }

        return inflater.inflate(R.layout.fragment_dashboard, container, false)
    }
}