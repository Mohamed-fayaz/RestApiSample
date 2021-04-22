package com.example.jokesapp

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

class JokeViewModel: ViewModel() {
    private var viewModelJob = Job()
    private val coroutineScope = CoroutineScope(viewModelJob + Dispatchers.Main)

    private val _status = MutableLiveData<String>()

    val status: LiveData<String>
        get() = _status

    private val _properties = MutableLiveData<List<JokesProperty>>()

    val properties: LiveData<List<JokesProperty>>
        get() = _properties
    init {
        getJokeProperties()
    }

    private fun getJokeProperties() {
        coroutineScope.launch {
            var getPropertiesDeferred = JokesApi.retrofitService.getProperties()

            try {

                var listResult = getPropertiesDeferred.await()
                _properties.value = listResult
                Log.i("value obtained",listResult.toString())

            } catch (e: Exception) {
                _status.value = e.message
            }

        }

    }
}