package ru.android.petwatch.view.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import ru.android.petwatch.R
import ru.android.petwatch.adapters.AnimalAdapter
import ru.android.petwatch.databinding.FragmentAnimalBinding
import ru.android.petwatch.listeners.AnimalClickListener
import ru.android.petwatch.model.Animal
import ru.android.petwatch.viewmodel.AnimalViewModel


private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"


private const val TAG = "ANIMAL_FRAGMENT"
class AnimalFragment : Fragment() {
    private var param1: String? = null
    private var param2: String? = null

    private lateinit var binding: FragmentAnimalBinding
    private lateinit var animalAdapter: AnimalAdapter
    private lateinit var animalViewModel: AnimalViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        Log.d(TAG, "mt onCreate")
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        Log.d(TAG, "mt onCreateView")
        binding = FragmentAnimalBinding.inflate(inflater)

        binding.btnCreateFirst.setOnClickListener { createAnimal(it) }
        binding.btnPlus.setOnClickListener{ createAnimal(it) }

        animalAdapter = AnimalAdapter(object : AnimalClickListener {
            override fun onDeleteAnimalClickListener(animal: Animal) {
                Log.d(TAG, "mt onDeleteAnimalClickListener")
            }

            override fun onItemClickListener(animal: Animal) {
                findNavController().navigate(R.id.action_animalFragment_to_animalEnterFragment)
                Log.d(TAG, "mt onItemClickListener")
            }
        })

        binding.rvAnimal.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = animalAdapter
        }

        animalViewModel = ViewModelProvider(requireActivity())[AnimalViewModel::class.java]

        animalViewModel.allAnimals.observe(viewLifecycleOwner) {
            Log.d(TAG, "ob getAllAnimalsObservers")
            if (it.isNotEmpty()) {
                Log.d(TAG, "ob getAllAnimalsObservers allAnimal size - ${it.size}")
                binding.tv1.visibility = View.GONE
                binding.tv2.visibility = View.GONE
                binding.rvAnimal.visibility = View.VISIBLE
                binding.imWolf.visibility = View.GONE
                binding.btnCreateFirst.visibility = View.GONE
            }
            animalAdapter.setListData(ArrayList(it))
            animalAdapter.notifyDataSetChanged()
        }


        return binding.root
    }

    private fun createAnimal(view : View) {
        Log.d(TAG, "mt createAnimal")
        view.findNavController().navigate(R.id.action_animalFragment_to_createAnimalFragment)
    }

    companion object {
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            AnimalFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}