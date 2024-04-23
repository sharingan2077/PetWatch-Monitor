package ru.android.petwatch.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "animalinfo")
data class Animal (
    @PrimaryKey(autoGenerate = true) val id : Int,
    @ColumnInfo(name = "name") val name: String,
    @ColumnInfo(name = "age") val age: String,
    @ColumnInfo(name = "gender") val gender: String,
    @ColumnInfo(name = "animal") val animal: String,
    @ColumnInfo(name = "breed") val breed: String,
    @ColumnInfo(name = "color") val color: String,
    @ColumnInfo(name = "where") val where: String,
    @ColumnInfo(name = "isCastrated") val isCastrated: Boolean,
) {
    override fun toString(): String {
        return "AnimalEntity(id=$id, name='$name', age='$age', gender='$gender', animal='$animal', breed='$breed', color='$color', where='$where', isCastrated=$isCastrated)"
    }
}