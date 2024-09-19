package com.example.fitfusionapp.homeScreen

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.fitfusionapp.R
import com.example.fitfusionapp.databinding.ItemsRecyclerBinding
import com.example.fitfusionapp.userInfo
import com.github.mikephil.charting.charts.BarChart
import com.github.mikephil.charting.data.BarData
import com.github.mikephil.charting.data.BarDataSet
import com.github.mikephil.charting.data.BarEntry
import com.mikhaellopez.circularprogressbar.CircularProgressBar


class HomeScreenAdapter(private val userInfo: List<userInfo>, var onItemClick : (userInfo) -> Unit) : RecyclerView.Adapter<HomeScreenAdapter.HomeScreenViewHolder>() {

    inner class HomeScreenViewHolder(private val binding: ItemsRecyclerBinding) : RecyclerView.ViewHolder(binding.root) {
        private val titleTextView: TextView = binding.titleCard
        private val stepCountTextView: TextView = binding.stepCount
        private val icon : ImageView = binding.iconCard
        private val walkProgressBar: CircularProgressBar = binding.progressCircular
        private val sleepBarChart: BarChart = binding.barChart.barChart
        private val imageReplace: ImageView = binding.imageView.img

        fun bind(user: userInfo) {
            titleTextView.text = user.title
            icon.setImageResource(user.icon)

            when (user.type) {
                0 -> {
                    val string = "${user.steps} steps"
                    stepCountTextView.text = string

                    walkProgressBar.visibility = View.VISIBLE
                    walkProgressBar.setProgressWithAnimation(user.progress ?: 0f)
                    sleepBarChart.visibility = View.GONE
                    imageReplace.visibility = View.GONE


                }
                1 -> {

                    walkProgressBar.visibility = View.GONE
                    stepCountTextView.visibility = View.GONE
                    sleepBarChart.visibility = View.VISIBLE
                    imageReplace.visibility = View.GONE

                    setupBarChart(sleepBarChart)

                }
                2 -> {

                    walkProgressBar.visibility = View.GONE
                    sleepBarChart.visibility = View.GONE
                    stepCountTextView.visibility = View.GONE
                    imageReplace.visibility = View.VISIBLE
                    imageReplace.setImageResource(user.image ?: R.drawable.img_card )


                }

            }
            binding.tileCard.setOnClickListener {
                onItemClick.invoke(user)
            }
        }
    }

    private fun setupBarChart(barChart: BarChart) {
        val entries = ArrayList<BarEntry>()
        entries.add(BarEntry(0f, 6f))
        entries.add(BarEntry(1f, 7f))
        entries.add(BarEntry(2f, 5f))
        entries.add(BarEntry(3f, 8f))
        entries.add(BarEntry(4f, 6.5f))

        val barDataSet = BarDataSet(entries, "")
        barDataSet.color = Color.rgb(47, 128, 237) // Customize bar color

        // Customize the bars
        val barData = BarData(barDataSet)
        barData.barWidth = 0.4f // Adjust bar width to make it thinner
        barChart.data = barData

        // Customize bar chart appearance
        barDataSet.setDrawValues(false)
        barChart.setDrawGridBackground(false) // Remove background grid
        barChart.setDrawBorders(false) // Remove borders
        barChart.description.isEnabled = false // Remove description text
        barChart.legend.isEnabled = false // Remove legend

        barChart.setTouchEnabled(false) // Disable touch gestures
        barChart.isDragEnabled = false // Disable dragging
        barChart.setScaleEnabled(false) // Disable scaling

        // Customize x-axis
        val xAxis = barChart.xAxis
        xAxis.setDrawGridLines(false) // Remove x-axis grid lines
        xAxis.setDrawAxisLine(false) // Remove x-axis line
        xAxis.isEnabled = false // Disable x-axis labels

        // Customize left axis
        val leftAxis = barChart.axisLeft
        leftAxis.setDrawGridLines(false) // Remove left axis grid lines
        leftAxis.setDrawAxisLine(false) // Remove left axis line
        leftAxis.isEnabled = false // Disable left axis labels

        // Customize right axis
        val rightAxis = barChart.axisRight
        rightAxis.setDrawGridLines(false) // Remove right axis grid lines
        rightAxis.setDrawAxisLine(false) // Remove right axis line
        rightAxis.isEnabled = false // Disable right axis labels

        barChart.axisLeft.isEnabled = false // Disable left axis labels
        barChart.axisRight.isEnabled = false // Disable right axis labels

        barChart.setPinchZoom(false)
        // Refresh the chart
        barChart.invalidate()

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeScreenViewHolder {
        val binding = ItemsRecyclerBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return HomeScreenViewHolder(binding)
    }

    override fun onBindViewHolder(holder: HomeScreenAdapter.HomeScreenViewHolder, position: Int) {
        holder.bind(userInfo[position])
    }

    override fun getItemCount(): Int = userInfo.size
}
