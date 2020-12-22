package com.udacity.shoestore.screens.shoelist

import android.os.Bundle
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
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
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding = ShoeListFragmentBinding.inflate(inflater, container, false)

        viewModel = ViewModelProvider(this).get(ShoeListViewModel::class.java)

        binding.shoeListViewModel = viewModel


        // adding the Logout to toolbar from this fragment - not sure if this is the best way
        val view: View = requireActivity().findViewById(R.id.toolbar)
        toolbar = view.findViewById<Toolbar>(R.id.toolbar)
        toolbar.inflateMenu(R.menu.menu)
        toolbar.setOnMenuItemClickListener {
            onOptionsItemSelected(it)
        }

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

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.logout -> {
                val action = ShoeListFragmentDirections.actionShoeListFragmentToLoginFragment()
                NavHostFragment.findNavController(this).navigate(action)
                toolbar.menu.clear() //this is ugly I think, but don't know how to do it better
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }


}