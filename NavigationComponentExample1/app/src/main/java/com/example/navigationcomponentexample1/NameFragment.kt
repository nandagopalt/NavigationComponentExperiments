package com.example.navigationcomponentexample1

import android.os.Bundle
import android.text.TextUtils
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.databinding.DataBindingUtil
import androidx.navigation.NavArgs
import androidx.navigation.findNavController
import androidx.navigation.fragment.navArgs
import com.example.navigationcomponentexample1.databinding.FragmentNameBinding

class NameFragment : Fragment() {
    private lateinit var binding: FragmentNameBinding
    private val args: NameFragmentArgs by navArgs()
    override fun onCreateView(
        layoutInflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(layoutInflater, R.layout.fragment_name, container, false)
        Toast.makeText(activity,args.title,Toast.LENGTH_LONG).show()
        binding.btnEmail.setOnClickListener {
            val name = binding.etName.text.toString()
            if(!TextUtils.isEmpty(name)) {
                val bundle = bundleOf("input_name" to name)
                it.findNavController().navigate(R.id.action_nameFragment_to_emailFragment, bundle)
            } else {
                Toast.makeText(activity, "Please enter name !", Toast.LENGTH_LONG).show()
            }
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
         * @return A new instance of fragment NameFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            NameFragment().apply {
                arguments = Bundle().apply {

                }
            }
    }
}