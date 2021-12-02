package com.example.dogproject.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.dogproject.network.Dog

@Database(entities = [Dog::class], version = 1)
abstract class DogDatabase : RoomDatabase() {
    abstract fun dogDao(): DogDao
}