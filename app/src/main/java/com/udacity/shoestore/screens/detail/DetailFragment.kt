package com.udacity.shoestore.screens.detail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.NavHostFragment
import com.udacity.shoestore.SharedViewModel
import com.udacity.shoestore.databinding.DetailFragmentBinding
import com.udacity.shoestore.models.Shoe

class DetailFragment : Fragment() {
    private val sharedViewModel: SharedViewModel by activityViewModels()
    lateinit var binding: DetailFragmentBinding
    private lateinit var viewModel: DetailViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {


        viewModel = ViewModelProvider(this).get(DetailViewModel::class.java)
        binding = DetailFragmentBinding.inflate(inflater, container, false)
        binding.shoe = Shoe("", 0.0, "", "")

//        binding.saveButton.setOnClickListener {
//            if (binding.shoe == null) {
//                Toast.makeText(activity, "Enter all properties", Toast.LENGTH_SHORT).show()
//            } else {
//                sharedViewModel.addShoe(binding.shoe!!)
//                val action = DetailFragmentDirections.actionDetailFragmentToShoeListFragment()
//                NavHostFragment.findNavController(this).navigate(action)
//            }
//        }

        binding.cancelButton.setOnClickListener {
            val action = DetailFragmentDirections.actionDetailFragmentToShoeListFragment()
            NavHostFragment.findNavController(this).navigate(action)
        }

        return binding.root
    }

    fun onSave(view: View) {

    }
}