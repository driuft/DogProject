package com.example.dogproject

import androidx.lifecycle.*
import com.example.dogproject.network.Dog
import com.example.dogproject.repository.DogRepository

class MainViewModel(): ViewModel() {
    val repository: DogRepository = DogRepository()
    internal val dogList : LiveData<List<Dog>> = repository.getDogs()
}