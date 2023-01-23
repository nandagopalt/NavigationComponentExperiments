package com.amalwin.navigationcomponentexample2

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.amalwin.navigationcomponentexample2.databinding.FragmentWelcomeBinding


class WelcomeFragment : Fragment() {

    private lateinit var binding: FragmentWelcomeBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_welcome, container, false)
        arguments.let {
            val name = it?.getString("name")
            val designation = it?.getString("designation")
            val email = it?.getString("email")

            val brief = "Welcome $name\n\n My name is $name\n" +
                    "I work as an $designation\n" +
                    "My email ID is $email."
            binding.txtWelcome.text = brief
        }
        binding.btnViewTc.setOnClickListener {
            it.findNavController().navigate(R.id.action_welcomeFragment_to_termsFragment)
        }
        return binding.root
    }
}