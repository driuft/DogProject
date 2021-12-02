package com.example.dogproject.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.dogproject.network.Dog

@Dao
interface DogDao {
    @Query("SELECT * FROM dog")
    fun getAll(): LiveData<List<Dog>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(vararg dog: Dog)
}