package ru.android.petwatch.listeners

import ru.android.petwatch.model.Animal

interface AnimalClickListener{
    fun onDeleteAnimalClickListener(animal: Animal)
    fun onItemClickListener(animal: Animal)
}