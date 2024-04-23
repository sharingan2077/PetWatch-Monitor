package ru.android.petwatch.view.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import com.bumptech.glide.Glide
import com.google.android.material.snackbar.Snackbar
import ru.android.petwatch.R
import ru.android.petwatch.databinding.FragmentCreateAnimalNextBinding

private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"
private const val TAG = "CREATE_ANIMAL_NEXT_FRAGMENT"

class CreateAnimalNextFragment : Fragment() {
    private var param1: String? = null
    private var param2: String? = null

    private lateinit var binding: FragmentCreateAnimalNextBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = FragmentCreateAnimalNextBinding.inflate(layoutInflater)
        Glide.with(this).asGif().load(R.drawable.a_dog_gif).into(binding.imgDogGif1)
        binding.btnNext1.setOnClickListener{
            if (correctInputData()) navigateToNext()
            else Snackbar.make( it, "Заполните поля!", Snackbar.LENGTH_SHORT).show()
        }

        return binding.root
    }

    private fun navigateToNext() {
        val bundle = Bundle()
        bundle.putString("NAME", binding.etName.text.toString())
        bundle.putString("BIRTHDAY", binding.etBirthday.text.toString())
        if (binding.rbMale.isEnabled) bundle.putString("GENDER", "male")
        else bundle.putString("GENDER", "female")
        this.view?.findNavController()?.navigate(R.id.action_createAnimalNextFragment_to_chooseAnimalFragment, bundle)
    }

    private fun correctInputData() : Boolean {
        if (binding.etName.text.toString() != "" && binding.etBirthday.text.toString() != ""
            && (binding.rbMale.isEnabled || binding.rbFemale.isEnabled)) {
            return true
        }
        return false
    }


    companion object {
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            CreateAnimalNextFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}