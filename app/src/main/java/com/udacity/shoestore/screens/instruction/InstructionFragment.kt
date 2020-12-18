package com.udacity.shoestore.screens.instruction

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.udacity.shoestore.databinding.InstructionFragmentBinding

class InstructionFragment : Fragment() {

    private lateinit var viewModel: InstructionViewModel
    private lateinit var binding: InstructionFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding = InstructionFragmentBinding.inflate(inflater, container, false)
        viewModel = ViewModelProvider(this).get(InstructionViewModel::class.java)

        binding.instructionViewModel = viewModel

        return binding.root
    }

}