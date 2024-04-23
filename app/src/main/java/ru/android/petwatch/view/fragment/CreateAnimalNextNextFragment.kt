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
import ru.android.petwatch.databinding.FragmentCreateAnimalNextNextBinding

private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"
private const val TAG = "CREATE_ANIMAL_NEXT_NEXT_FRAGMENT"

class CreateAnimalNextNextFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    private lateinit var binding: FragmentCreateAnimalNextNextBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = FragmentCreateAnimalNextNextBinding.inflate(layoutInflater)
        Glide.with(this).asGif().load(R.drawable.a_dog_gif).into(binding.imgDogGif2)
        binding.btnNext2.setOnClickListener{
            if (correctInputData()) navigateToNext()
            else Snackbar.make(it, "Заполните необходимые поля!", Snackbar.LENGTH_SHORT).show()
        }


        return binding.root
    }

    private fun navigateToNext() {
        val bundle = Bundle(requireArguments())
        bundle.putString("BREED", binding.etBreed.text.toString())
        bundle.putString("COLOR", binding.etColor.text.toString())
        this.view?.findNavController()?.navigate(R.id.action_createAnimalNextNextFragment_to_createNewAnimalNextNextNextFragment, bundle)
    }

    private fun correctInputData() : Boolean {
        if (binding.etBreed.text.toString() != "" && binding.etColor.text.toString() != "") {
            return true
        }
        return false
    }
    companion object {
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            CreateAnimalNextNextFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}