package com.udacity.shoestore.screens.detail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.NavHostFragment
import com.udacity.shoestore.SavedState
import com.udacity.shoestore.SharedViewModel
import com.udacity.shoestore.databinding.DetailFragmentBinding
import com.udacity.shoestore.models.Shoe

class DetailFragment : Fragment() {
    private val sharedViewModel: SharedViewModel by activityViewModels()
    lateinit var binding: DetailFragmentBinding
    private lateinit var viewModel: DetailViewModel
    private lateinit var toolbar : Toolbar

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {


        viewModel = ViewModelProvider(this).get(DetailViewModel::class.java)
        binding = DetailFragmentBinding.inflate(inflater, container, false)
        binding.lifecycleOwner = this
        binding.shoe = Shoe("", 0.0, "", "")
        binding.sharedViewModel = sharedViewModel


        sharedViewModel.saveState.observe(viewLifecycleOwner, Observer {
            if (it == com.udacity.shoestore.SavedState.ERROR) {
                Toast.makeText(activity, "Fill all inputs.", Toast.LENGTH_SHORT).show()
                sharedViewModel.resetSavedState()
            }


            if (it == com.udacity.shoestore.SavedState.SUCCESS) {
                Toast.makeText(activity, "Shoe added", Toast.LENGTH_SHORT).show()
                val action = DetailFragmentDirections.actionDetailFragmentToShoeListFragment()
                NavHostFragment.findNavController(this).navigate(action)
                sharedViewModel.resetSavedState()
            }
        })

        binding.cancelButton.setOnClickListener {
            val action = DetailFragmentDirections.actionDetailFragmentToShoeListFragment()
            NavHostFragment.findNavController(this).navigate(action)
        }

        return binding.root
    }
}