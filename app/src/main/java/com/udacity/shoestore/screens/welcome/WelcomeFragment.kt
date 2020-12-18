package com.udacity.shoestore.screens.welcome

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.NavHostFragment
import com.udacity.shoestore.databinding.WelcomeFragmentBinding

class WelcomeFragment : Fragment() {

    private lateinit var viewModel: WelcomeViewModel
    private lateinit var binding: WelcomeFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding = WelcomeFragmentBinding.inflate(inflater, container, false)
        viewModel = ViewModelProvider(this).get(WelcomeViewModel::class.java)

        binding.welcomeViewModel = viewModel
        binding.lifecycleOwner = this


        viewModel.eventNext.observe(viewLifecycleOwner, Observer { eventLoginOrCreate ->
            if (eventLoginOrCreate) {
                val action = WelcomeFragmentDirections.actionWelcomeFragmentToInstructionFragment()
                NavHostFragment.findNavController(this).navigate(action)
                viewModel.onNextDone()
            }
        })

        return binding.root
    }


}