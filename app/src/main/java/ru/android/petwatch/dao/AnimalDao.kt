package ru.android.petwatch.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import ru.android.petwatch.model.Animal

@Dao
interface AnimalDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertAnimal(animal: Animal)

    @Update
    suspend fun updateAnimal(animal: Animal)

    @Delete
    suspend fun deleteAnimal(animal: Animal)

    @Query("SELECT * FROM animalinfo")
    fun getAllAnimals(): LiveData<List<Animal>>

    @Query("DELETE FROM animalinfo")
    suspend fun deleteAllAnimals()

}