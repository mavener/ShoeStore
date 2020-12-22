package com.udacity.shoestore

import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupWithNavController
import com.udacity.shoestore.databinding.ActivityMainBinding
import com.udacity.shoestore.screens.instruction.InstructionFragmentDirections
import com.udacity.shoestore.screens.shoelist.ShoeListFragmentDirections
import kotlinx.android.synthetic.main.activity_main.*
import timber.log.Timber

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val navController = this.findNavController(R.id.nav_host_fragment)
        val appBarConfiguration = AppBarConfiguration(navController.graph)

        binding.toolbar.setupWithNavController(navController, appBarConfiguration)

//        binding.toolbar.inflateMenu(R.menu.menu)
//        binding.toolbar.setOnMenuItemClickListener {
//            onOptionsItemSelected(it)
//        }

        navController.addOnDestinationChangedListener { _, destination, _ ->
            toolbar.title = destination.label
            toolbar.navigationIcon = null

            //TODO show Up Navigation if destionation == Detail
        }

        Timber.plant(Timber.DebugTree())
    }

//    override fun onOptionsItemSelected(item: MenuItem): Boolean {
//        return when (item.itemId) {
//            R.id.logout -> {
//                val action = ShoeListFragmentDirections.actionShoeListFragmentToLoginFragment()
//                NavHostFragment.findNavController(this).navigate(action)
//                return true
//            }
//            else -> super.onOptionsItemSelected(item)
//        }
//    }


}
