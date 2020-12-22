package com.udacity.shoestore.screens.shoelist

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.NavHostFragment
import com.udacity.shoestore.R
import com.udacity.shoestore.SharedViewModel
import com.udacity.shoestore.databinding.ShoeListFragmentBinding
import com.udacity.shoestore.databinding.ShoeViewBinding
import com.udacity.shoestore.screens.login.LoginFragmentDirections
import com.udacity.shoestore.screens.login.LoginViewModel
import timber.log.Timber

class ShoeListFragment : Fragment() {

    private val sharedViewModel: SharedViewModel by activityViewModels()

    private lateinit var binding: ShoeListFragmentBinding
    private lateinit var viewModel : ShoeListViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding = ShoeListFragmentBinding.inflate(inflater, container, false)

        viewModel = ViewModelProvider(this).get(ShoeListViewModel::class.java)

        binding.shoeListViewModel = viewModel

        sharedViewModel.shoeList.observe(viewLifecycleOwner, Observer {
            for (shoe in it) {
                val shoeViewBinding = ShoeViewBinding.inflate(inflater, binding.linearLayout, true)
                shoeViewBinding.shoe = shoe

                shoeViewBinding.root.setOnClickListener {
                    Toast.makeText(activity, shoe.name, Toast.LENGTH_SHORT).show()
                }
            }
        })

        viewModel.eventAddShoe.observe(viewLifecycleOwner, Observer {
            it.getContentIfNotHandled()?.let {
                val action = ShoeListFragmentDirections.actionShoeListFragmentToDetailFragment()
                NavHostFragment.findNavController(this).navigate(action)
            }
        })

        return binding.root
    }
}