package ru.android.petwatch.view.activity

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import ru.android.petwatch.R
import ru.android.petwatch.databinding.ActivityMainBinding
import ru.android.petwatch.viewmodel.AnimalViewModel
import ru.android.petwatch.viewmodel.MainViewModel

private const val TAG = "MAIN_ACTIVITY"

class MainActivity : AppCompatActivity() {

    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: ActivityMainBinding
    private lateinit var mainViewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val navController = findNavController(R.id.nav_host_fragment_content_main)
        binding.bottomNavigationBar.setupWithNavController(navController)

        setSupportActionBar(binding.toolbar)
        appBarConfiguration = AppBarConfiguration(navController.graph)
        setupActionBarWithNavController(navController, appBarConfiguration)

        mainViewModel = ViewModelProvider(this)[MainViewModel::class.java]
        mainViewModel.showToolBar.observeForever {
            Log.i("TAG", "observeForever")
            if (it) {
                binding.toolbar.visibility = View.VISIBLE
            }
            else binding.toolbar.visibility = View.GONE
        }

//        val animalViewModelFactory = AnimalViewModel.AnimalViewModelFactory(application)
//        val animalViewModel = ViewModelProvider(this, animalViewModelFactory)[AnimalViewModel::class.java]
//        this.deleteDatabase("AppDTB")




    }


//    override fun onCreateOptionsMenu(menu: Menu): Boolean {
//        // Inflate the menu; this adds items to the action bar if it is present.
//        menuInflater.inflate(R.menu.menu_main, menu)
//        return true
//    }
//
//    override fun onOptionsItemSelected(item: MenuItem): Boolean {
//        // Handle action bar item clicks here. The action bar will
//        // automatically handle clicks on the Home/Up button, so long
//        // as you specify a parent activity in AndroidManifest.xml.
//        return when (item.itemId) {
//            R.id.action_settings -> true
//            else -> super.onOptionsItemSelected(item)
//        }
//    }
//
    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.nav_host_fragment_content_main)
        return navController.navigateUp(appBarConfiguration) || super.onSupportNavigateUp()
    }
}