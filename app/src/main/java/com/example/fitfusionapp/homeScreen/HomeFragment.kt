package com.example.fitfusionapp.homeScreen

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.fitfusionapp.R
import com.example.fitfusionapp.databinding.FragmentHomeBinding
import com.example.fitfusionapp.homeScreen.HomeScreenAdapter
import com.example.fitfusionapp.userInfo

class HomeFragment : Fragment() {

    private lateinit var binding: FragmentHomeBinding
    private lateinit var homeScreenAdapter: HomeScreenAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val userData = listOf(
            userInfo(type = 0, icon = R.drawable.ic_walk, title = "Walk", steps = 6500, progress = 75f, image = null),
            userInfo(type = 1, icon = R.drawable.ic_sleep, title = "Sleep", steps = null, progress = null, sleepData = listOf(7f, 6.5f, 8f, 5f), image = null),
            userInfo(type = 2, icon = R.drawable.baseline_calculate_24, title = "BMI", steps = null, progress = null, image = R.drawable.img_card),
            userInfo(type = 2, icon = R.drawable.ic_lightbulb, title = "Exercises", steps = null, progress = null, image = R.drawable.img_card),
            userInfo(type = 2, icon = R.drawable.ic_water, title = "Water", steps = null, progress = null, image = R.drawable.img_card),
        )



        homeScreenAdapter = HomeScreenAdapter(userData, onItemClick = {selectedCard ->
            when(selectedCard.title){
                "Walk" -> findNavController().navigate(R.id.action_homeFragment_to_walkFragment)
                "BMI" -> findNavController().navigate(R.id.action_homeFragment_to_bmiCalculatorFragment)
            }
        })


        binding.recyclerView.adapter = homeScreenAdapter
    }
}
