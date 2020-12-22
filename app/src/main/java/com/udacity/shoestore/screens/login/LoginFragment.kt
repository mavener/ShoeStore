package com.udacity.shoestore.screens.login

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.NavHostFragment
import com.udacity.shoestore.databinding.LoginFragmentBinding

class LoginFragment : Fragment() {

    private lateinit var viewModel: LoginViewModel
    private lateinit var binding : LoginFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        viewModel = ViewModelProvider(this).get(LoginViewModel::class.java)

        binding = LoginFragmentBinding.inflate(inflater, container, false)

        binding.loginViewModel = viewModel
       // binding.lifecycleOwner = this

        viewModel.eventLoginOrCreate.observe(viewLifecycleOwner, Observer {
            it.getContentIfNotHandled()?.let {
                val action = LoginFragmentDirections.actionLoginFragmentToWelcomeFragment()
                NavHostFragment.findNavController(this).navigate(action)
            }
        })


        return binding.root
    }

}