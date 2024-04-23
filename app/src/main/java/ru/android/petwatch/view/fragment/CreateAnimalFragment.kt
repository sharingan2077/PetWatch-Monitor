package ru.android.petwatch.view.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import com.bumptech.glide.Glide
import ru.android.petwatch.R
import ru.android.petwatch.databinding.FragmentCreateAnimalBinding
import ru.android.petwatch.viewmodel.MainViewModel


private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"
private const val TAG = "CREATE_ANIMAL_FRAGMENT"
class CreateAnimalFragment : Fragment() {
    private var param1: String? = null
    private var param2: String? = null

    private lateinit var binding: FragmentCreateAnimalBinding
    private lateinit var mainViewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentCreateAnimalBinding.inflate(inflater)
        Glide.with(this).asGif().load(R.drawable.a_cat2_gif).into(binding.imgCatGif)
        binding.btnCreate.setOnClickListener {

            this.view?.findNavController()?.navigate(R.id.action_createAnimalFragment_to_createAnimalNextFragment)
        }
        mainViewModel = ViewModelProvider(requireActivity())[MainViewModel::class.java]
        mainViewModel.showToolBar.value = true


        return binding.root

    }

    companion object {
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            CreateAnimalFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}