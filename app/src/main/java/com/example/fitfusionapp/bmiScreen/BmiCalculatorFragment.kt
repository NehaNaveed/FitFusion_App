package com.example.fitfusionapp.bmiScreen

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.fitfusionapp.R
import com.example.fitfusionapp.databinding.FragmentBmiCalculatorBinding

class BmiCalculatorFragment : Fragment() {

    private lateinit var binding: FragmentBmiCalculatorBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding = FragmentBmiCalculatorBinding.inflate(layoutInflater)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.calculateButton.setOnClickListener(){
            val weight = (binding.weight.text.toString()).toFloat()
            val height = (binding.height.text.toString()).toFloat()/100

            val bmi = weight/height*height
            val string = "Your BMI is : $bmi"
            binding.resultText.text = string


        }

    }
}