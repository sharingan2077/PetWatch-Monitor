package ru.android.petwatch.viewmodel

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import ru.android.petwatch.model.Animal
import ru.android.petwatch.repositories.AnimalRepository
import ru.android.petwatch.repositories.RoomAppDtb


private const val TAG_1 = "ANIMAL_VIEW_MODEL"
private const val TAG_2 = "ANIMAL_VIEW_MODEL_FACTORY"

class AnimalViewModel(app: Application): AndroidViewModel(app) {


    var allAnimals : LiveData<List<Animal>>
    private val repository : AnimalRepository


    class AnimalViewModelFactory(private val app : Application) : ViewModelProvider.Factory {
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            Log.d(TAG_2, "mt create")
            if (modelClass.isAssignableFrom(AnimalViewModel::class.java)) {
                return AnimalViewModel(app) as T
            }
            throw IllegalArgumentException("Unknown ViewModel class")
        }
    }

    init{
        Log.d(TAG_1, "mt init")
        val animalDao = RoomAppDtb.getAppDatabase(getApplication()).animalDao()
        repository = AnimalRepository(animalDao)
        allAnimals = repository.allAnimals
    }

    fun insertAnimal(animal: Animal){
        Log.d(TAG_1, "mt insertAnimal")
        viewModelScope.launch(Dispatchers.IO) {
            repository.insertAnimal(animal)
            allAnimals = repository.allAnimals
        }
    }

    fun updateAnimal(animal: Animal){
        Log.d(TAG_1, "mt updateAnimal")
        viewModelScope.launch(Dispatchers.IO) {
            Log.d(TAG_1, "mt updateAnimal - $animal")
            repository.updateAnimal(animal)
            Log.d(TAG_1, "mt updateAnimal complete")
            allAnimals = repository.allAnimals
            Log.d(TAG_1, "mt updateAnimal allAnimals - ${allAnimals.value}")
        }
    }

    fun deleteAnimal(animal: Animal){
        Log.d(TAG_1, "mt deleteAnimal")
        viewModelScope.launch(Dispatchers.IO) {
            repository.deleteAnimal(animal)
            allAnimals = repository.allAnimals
        }
    }

    fun deleteAllAnimals() {
        Log.d(TAG_1, "mt deleteAllAnimals")
        viewModelScope.launch(Dispatchers.IO) {
            repository.deleteAllAnimal()
            allAnimals = repository.allAnimals
        }
    }

}