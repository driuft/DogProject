package com.example.dogproject.repository

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.dogproject.ApplicationManager
import com.example.dogproject.network.Dog
import com.example.dogproject.network.DogApi
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.lang.Exception

class DogRepository {
    private val serviceScope = CoroutineScope(Dispatchers.Default)

    init {
        serviceScope.launch (Dispatchers.IO) {
            getRandomDog()
        }
    }

    suspend fun getRandomDog() {
        try {
            val dog = DogApi.retrofitService.getRandomDogImage()
            ApplicationManager.db.dogDao().insertAll(dog)
        } catch (e: Exception) {
            Log.e("MainViewModel", "Error occurred: ${e.message}")
        }
    }

    fun getDogs(): LiveData<List<Dog>> {
        return ApplicationManager.db.dogDao().getAll()
    }

//    suspend fun getRandomBreed(breed: String) {
//        Log.d("MainViewModel", "This is the breed: ${breed}")
//        try {
//            //_apiResponse.value = DogApi.retrofitService.getRandomBreedImage(breed)
//        } catch (e: Exception) {
//            Log.e("MainViewModel", "Error occurred: ${e.message}")
//        }
//    }
}