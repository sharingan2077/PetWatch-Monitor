package ru.android.petwatch.repositories

import android.util.Log
import androidx.lifecycle.LiveData
import ru.android.petwatch.adapters.AnimalAdapter
import ru.android.petwatch.dao.AnimalDao
import ru.android.petwatch.model.Animal


private const val TAG = "ANIMAL_REPOSITORY"
class AnimalRepository(private val animalDao: AnimalDao) {

    var allAnimals: LiveData<List<Animal>> = animalDao.getAllAnimals()

    suspend fun insertAnimal(animal: Animal) {
        Log.d(TAG, "mt insertAnimal")
        animalDao.insertAnimal(animal)
        updateAllAnimals()
    }

    suspend fun updateAnimal(animal: Animal) {
        Log.d(TAG, "mt updateAnimal - $animal")
        animalDao.updateAnimal(animal)
        updateAllAnimals()
    }

    suspend fun deleteAnimal(animal: Animal) {
        Log.d(TAG, "mt deleteAnimal")
        animalDao.deleteAnimal(animal)
        updateAllAnimals()
    }

    suspend fun deleteAllAnimal(){
        Log.d(TAG, "mt deleteAllAnimal")
        animalDao.deleteAllAnimals()
        updateAllAnimals()
    }

    private fun updateAllAnimals() {
        allAnimals = animalDao.getAllAnimals();
        Log.d(TAG, "mt updateAllAnimals allAnimals - ${allAnimals.value}")
    }

}