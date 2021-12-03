package com.example.navigationcomponentexample1

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import com.example.navigationcomponentexample1.databinding.FragmentEmailBinding
import com.example.navigationcomponentexample1.databinding.FragmentNameBinding

class EmailFragment : Fragment() {
    private lateinit var binding: FragmentEmailBinding
    override fun onCreateView(
                    layoutInflater:LayoutInflater,
                    container: ViewGroup?,
                    savedInstanceState: Bundle?): View {
        binding = DataBindingUtil.inflate(layoutInflater, R.layout.fragment_email, container, false)
        val name = arguments?.getString("input_name")
        binding.btnWelcome.setOnClickListener {
            val email = binding.etEmail1.text.toString()
            val bundle = bundleOf("input_name" to name, "input_email" to email)
            it.findNavController().navigate(R.id.action_emailFragment_to_welcomeFragment, bundle)
        }
        return binding.root
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment EmailFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            EmailFragment().apply {
                arguments = Bundle().apply {

                }
            }
    }
}