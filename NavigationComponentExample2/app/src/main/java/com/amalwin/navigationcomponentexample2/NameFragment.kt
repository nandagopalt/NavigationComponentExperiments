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
import com.amalwin.navigationcomponentexample2.databinding.FragmentNameBinding


class NameFragment : Fragment() {

    private lateinit var binding: FragmentNameBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_name, container, false)
        binding.btnNext.setOnClickListener {
            if ( !TextUtils.isEmpty(binding.etName.text) && !TextUtils.isEmpty(binding.etDesignation.text) ) {
                val bundle =
                    bundleOf("name" to binding.etName.text.toString(),
                        "designation" to binding.etDesignation.text.toString())
                it.findNavController().navigate(R.id.action_nameFragment_to_emailFragment, bundle)
            } else {
                Toast.makeText(
                    requireActivity(),
                    "Name/Designation field to be filled !",
                    Toast.LENGTH_SHORT
                )
                    .show()
            }
        }
        return binding.root
    }

}