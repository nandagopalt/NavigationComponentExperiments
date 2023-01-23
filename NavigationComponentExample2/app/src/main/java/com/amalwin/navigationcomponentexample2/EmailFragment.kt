package com.amalwin.navigationcomponentexample2

import android.os.Bundle
import android.text.TextUtils
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.amalwin.navigationcomponentexample2.databinding.FragmentEmailBinding


class EmailFragment : Fragment() {

    private lateinit var binding: FragmentEmailBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_email, container, false)
        arguments.let {
            val name = it?.getString("name")
            val designation = it?.getString("designation")
            Toast.makeText(requireActivity(), "$name and $designation", Toast.LENGTH_SHORT).show()
            binding.btnSubmit.setOnClickListener {
                if (!TextUtils.isEmpty(binding.etEmail.text)) {
                    val bundle = bundleOf(
                        "name" to name,
                        "designation" to designation,
                        "email" to binding.etEmail.text.toString()
                    )
                    it.findNavController()
                        .navigate(R.id.action_emailFragment_to_welcomeFragment, bundle)
                } else {
                    Toast.makeText(
                        requireActivity(),
                        "Email need to be filled !",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }
        }
        return binding.root
    }
}