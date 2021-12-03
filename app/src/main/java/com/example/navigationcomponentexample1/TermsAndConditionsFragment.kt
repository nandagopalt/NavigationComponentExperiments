package com.example.navigationcomponentexample1

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.example.navigationcomponentexample1.databinding.FragmentTermsAndConditionsBinding

class TermsAndConditionsFragment : Fragment() {
    private lateinit var binding: FragmentTermsAndConditionsBinding
    override fun onCreateView(
        layoutInflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(
            layoutInflater, R.layout.fragment_terms_and_conditions,
            container, false
        )
        return binding.root
    }


    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment TermsAndConditionsFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            TermsAndConditionsFragment().apply {
                arguments = Bundle().apply {

                }
            }
    }
}