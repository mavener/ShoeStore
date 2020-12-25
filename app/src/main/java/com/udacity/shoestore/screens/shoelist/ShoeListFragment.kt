package com.udacity.shoestore.screens.shoelist

import android.os.Bundle
import android.view.*
import android.widget.Toast
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import com.udacity.shoestore.R
import com.udacity.shoestore.SharedViewModel
import com.udacity.shoestore.databinding.ShoeListFragmentBinding
import com.udacity.shoestore.databinding.ShoeViewBinding

class ShoeListFragment : Fragment() {

    private val sharedViewModel: SharedViewModel by activityViewModels()

    private lateinit var binding: ShoeListFragmentBinding
    private lateinit var viewModel: ShoeListViewModel
    private lateinit var toolbar : Toolbar

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {

        binding = ShoeListFragmentBinding.inflate(inflater, container, false)

        viewModel = ViewModelProvider(this).get(ShoeListViewModel::class.java)

        binding.shoeListViewModel = viewModel



        sharedViewModel.shoeList.observe(viewLifecycleOwner, Observer {
            for (shoe in it) {
                val shoeViewBinding = ShoeViewBinding.inflate(inflater, binding.linearLayout, true)
                shoeViewBinding.shoe = shoe
            }
        })

        viewModel.eventAddShoe.observe(viewLifecycleOwner, Observer {
            it.getContentIfNotHandled()?.let {
                val action = ShoeListFragmentDirections.actionShoeListFragmentToDetailFragment()
                NavHostFragment.findNavController(this).navigate(action)
            }
        })

        setHasOptionsMenu(true)

        return binding.root
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.logout -> {
                val action = ShoeListFragmentDirections.actionShoeListFragmentToLoginFragment()
                NavHostFragment.findNavController(this).navigate(action)
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.menu, menu)
    }
}