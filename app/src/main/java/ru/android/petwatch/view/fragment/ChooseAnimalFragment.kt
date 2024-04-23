package ru.android.petwatch.view.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import ru.android.petwatch.R
import ru.android.petwatch.databinding.FragmentChooseAnimalBinding


private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"
private const val TAG = "CHOOSE_ANIMAL_FRAGMENT"

class ChooseAnimalFragment : Fragment() {
    private var param1: String? = null
    private var param2: String? = null

    private lateinit var binding: FragmentChooseAnimalBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = FragmentChooseAnimalBinding.inflate(inflater)
        //Собака
        binding.vDog.setOnClickListener { createAnimal(binding.tvDog.text.toString()) }
        binding.tvDog.setOnClickListener { createAnimal(binding.tvDog.text.toString()) }
        //Кошка
        binding.vCat.setOnClickListener { createAnimal(binding.tvCat.text.toString()) }
        binding.tvCat.setOnClickListener { createAnimal(binding.tvCat.text.toString()) }
        //Мышь
        binding.vMouse.setOnClickListener { createAnimal(binding.tvMouse.text.toString()) }
        binding.tvMouse.setOnClickListener { createAnimal(binding.tvMouse.text.toString()) }
        //Ящерица
        binding.vLizard.setOnClickListener { createAnimal(binding.tvLizard.text.toString()) }
        binding.tvLizard.setOnClickListener { createAnimal(binding.tvLizard.text.toString()) }
        //Рыба
        binding.vFish.setOnClickListener { createAnimal(binding.tvFish.text.toString()) }
        binding.tvFish.setOnClickListener { createAnimal(binding.tvFish.text.toString()) }
        //Хорек
        binding.vFerret.setOnClickListener { createAnimal(binding.tvFerret.text.toString()) }
        binding.tvFerret.setOnClickListener { createAnimal(binding.tvFerret.text.toString()) }
        //Шиншилла
        binding.vErmine.setOnClickListener { createAnimal(binding.tvErmine.text.toString()) }
        binding.tvErmine.setOnClickListener { createAnimal(binding.tvErmine.text.toString()) }
        //Змея
        binding.vSnake.setOnClickListener { createAnimal(binding.tvSnake.text.toString()) }
        binding.tvSnake.setOnClickListener { createAnimal(binding.tvSnake.text.toString()) }
        //Черепаха
        binding.vTurtle.setOnClickListener { createAnimal(binding.tvTurtle.text.toString()) }
        binding.tvTurtle.setOnClickListener { createAnimal(binding.tvTurtle.text.toString()) }
        //Кролик
        binding.vRabbit.setOnClickListener { createAnimal(binding.tvRabbit.text.toString()) }
        binding.tvRabbit.setOnClickListener { createAnimal(binding.tvRabbit.text.toString()) }
        //Морская свинка
        binding.vGuinea.setOnClickListener { createAnimal(binding.tvGuinea.text.toString()) }
        binding.tvGuinea.setOnClickListener { createAnimal(binding.tvGuinea.text.toString()) }
        //Лошадь
        binding.vHorse.setOnClickListener { createAnimal(binding.tvHorse.text.toString()) }
        binding.tvHorse.setOnClickListener { createAnimal(binding.tvHorse.text.toString()) }
        //Осел
        binding.vDonkey.setOnClickListener { createAnimal(binding.tvDonkey.text.toString()) }
        binding.tvDonkey.setOnClickListener { createAnimal(binding.tvDonkey.text.toString()) }
        //Свинья
        binding.vPig.setOnClickListener { createAnimal(binding.tvPig.text.toString()) }
        binding.tvPig.setOnClickListener { createAnimal(binding.tvPig.text.toString()) }
        //Коза
        binding.vGoat.setOnClickListener { createAnimal(binding.tvGoat.text.toString()) }
        binding.tvGoat.setOnClickListener { createAnimal(binding.tvGoat.text.toString()) }
        //Овца
        binding.vSheep.setOnClickListener { createAnimal(binding.tvSheep.text.toString()) }
        binding.tvSheep.setOnClickListener { createAnimal(binding.tvSheep.text.toString()) }
        //Корова
        binding.vCow.setOnClickListener { createAnimal(binding.tvCow.text.toString()) }
        binding.tvCow.setOnClickListener { createAnimal(binding.tvCow.text.toString()) }
        //Птица
        binding.vBird.setOnClickListener { createAnimal(binding.tvBird.text.toString()) }
        binding.tvBird.setOnClickListener { createAnimal(binding.tvBird.text.toString()) }
        //Курица
        binding.vChicken.setOnClickListener { createAnimal(binding.tvChicken.text.toString()) }
        binding.tvChicken.setOnClickListener { createAnimal(binding.tvChicken.text.toString()) }
        //Утка
        binding.vDuck.setOnClickListener { createAnimal(binding.tvDuck.text.toString()) }
        binding.tvDuck.setOnClickListener { createAnimal(binding.tvDuck.text.toString()) }

        return binding.root
    }

    private fun createAnimal(animal : String) {
        val bundle = Bundle(requireArguments())
        bundle.putString("ANIMAL", animal)
        this.requireView().findNavController().navigate(R.id.action_chooseAnimalFragment_to_createAnimalNextNextFragment, bundle)
    }


    companion object {
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            ChooseAnimalFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}