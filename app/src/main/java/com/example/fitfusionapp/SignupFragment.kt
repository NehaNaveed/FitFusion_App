package com.example.fitfusionapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.example.fitfusionapp.databinding.FragmentSignupBinding
import com.google.firebase.auth.FirebaseAuth

class SignupFragment : Fragment() {
   private lateinit var binding :FragmentSignupBinding
   private var firebase : FirebaseAuth = FirebaseAuth.getInstance()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentSignupBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.signUpButton.setOnClickListener(){
            val email = binding.emailText.text.toString()
            val psw = binding.passText.text.toString()
            val psw_repeat = binding.passAgain.text.toString()

            if(email.isNotEmpty() && psw.isNotEmpty() && psw_repeat.isNotEmpty())
            {
                if(psw == psw_repeat){
                    firebase.createUserWithEmailAndPassword(email,psw).addOnCompleteListener {
                        if (it.isSuccessful){
                            Toast.makeText(requireContext(),"Account created successfully!",Toast.LENGTH_SHORT).show()
                            findNavController().navigate(R.id.action_signupFragment_to_homeFragment)

                        }
                        else
                            Toast.makeText(requireContext(),it.exception.toString(),Toast.LENGTH_SHORT).show()
                    }
                }
                else{
                    Toast.makeText(requireContext(),"Password does not match", Toast.LENGTH_SHORT).show()

                }
            }
            else{
                Toast.makeText(requireContext(),"Empty fields are not allowed",Toast.LENGTH_SHORT).show()
            }
        }
    }


}