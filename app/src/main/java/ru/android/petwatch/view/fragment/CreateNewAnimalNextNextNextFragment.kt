package ru.android.petwatch.view.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import com.bumptech.glide.Glide
import com.google.android.material.snackbar.Snackbar
import ru.android.petwatch.R
import ru.android.petwatch.databinding.FragmentCreateNewAnimalNextNextNextBinding
import ru.android.petwatch.model.Animal
import ru.android.petwatch.viewmodel.AnimalViewModel


private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"
private const val TAG = "CREATE_NEW_ANIMAL_NEXT_NEXT_NEXT_FRAGMENT"

class CreateNewAnimalNextNextNextFragment : Fragment() {

    private var param1: String? = null
    private var param2: String? = null

    private lateinit var binding: FragmentCreateNewAnimalNextNextNextBinding
    private lateinit var animalViewModel: AnimalViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = FragmentCreateNewAnimalNextNextNextBinding.inflate(layoutInflater)
        Glide.with(this).asGif().load(R.drawable.a_dog1_gif).into(binding.imgDogGif3)
        binding.btnComplete.setOnClickListener{
            if (correctInputData()) complete()
            else Snackbar.make(it, "Заполните необходимые поля!", Snackbar.LENGTH_SHORT).show()
        }

        animalViewModel = ViewModelProvider(requireActivity())[AnimalViewModel::class.java]



        return binding.root
    }


    private fun complete() {
        val bundle = requireArguments()
        val name = bundle.getString("NAME")
        val gender = bundle.getString("GENDER")
        val age = bundle.getString("BIRTHDAY")
        val animal = bundle.getString("ANIMAL")
        val breed = bundle.getString("BREED")
        val color = bundle.getString("COLOR")
        val where = if (binding.rbHouse.isEnabled) "house" else "street"
        val isCastrated = if (binding.rbYes.isEnabled) true else false
        val animalEntity = Animal(0, name!!, age!!, gender!!, animal!!, breed!!, color!!, where, isCastrated)
        animalViewModel.insertAnimal(animalEntity)

        this.view?.findNavController()?.navigate(R.id.action_createNewAnimalNextNextNextFragment_to_animalEmptyFragment)
    }
    private fun correctInputData() : Boolean {
        return (binding.rbHouse.isEnabled || binding.rbStreet.isEnabled) &&
                (binding.rbNo.isEnabled || binding.rbYes.isEnabled)
    }



    companion object {
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            CreateNewAnimalNextNextNextFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}