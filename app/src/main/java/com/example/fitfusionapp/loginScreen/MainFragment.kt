package com.example.fitfusionapp.loginScreen

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.example.fitfusionapp.R
import com.example.fitfusionapp.databinding.FragmentMainBinding
import com.google.firebase.auth.FirebaseAuth


class MainFragment : Fragment() {
    private lateinit var binding : FragmentMainBinding
    private var firebase : FirebaseAuth = FirebaseAuth.getInstance()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding =  FragmentMainBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.loginButton.setOnClickListener(){
            findNavController().navigate(R.id.action_mainFragment_to_homeFragment)
//            val email = binding.emailText.text.toString()
//            val psw = binding.passText.text.toString()
//
//            if(email.isNotEmpty() && psw.isNotEmpty())
//            {
//
//                    firebase.signInWithEmailAndPassword(email,psw).addOnCompleteListener {
//                        if (it.isSuccessful){
//                            Toast.makeText(requireContext(),"Logged In successfully!",Toast.LENGTH_SHORT).show()
//
//                            findNavController().navigate(R.id.action_mainFragment_to_homeFragment)
//
//                        }
//                        else
//                            Toast.makeText(requireContext(),it.exception.toString(), Toast.LENGTH_SHORT).show()
//                    }
//
//
//            }
//            else{
//                Toast.makeText(requireContext(),"Empty fields are not allowed", Toast.LENGTH_SHORT).show()
//            }
        }
        binding.signUpButton.setOnClickListener(){
            findNavController().navigate(R.id.action_mainFragment_to_signupFragment)
        }

    }


}