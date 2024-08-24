package com.example.nasa_api.nasaapi

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.nasa_api.nasaapi.data.model.ResponsImageOfTheDay
import com.example.nasa_api.nasaapi.data.remote.api.Network
import kotlinx.coroutines.launch

class HomeViewModel:ViewModel() {

private  val _ImageoftheDay=MutableLiveData<ResponsImageOfTheDay>()

    val imageOfDay:LiveData<ResponsImageOfTheDay>
          get()= _ImageoftheDay


    init {
        getImageOfDay()
    }

    private fun getImageOfDay() {

       viewModelScope.launch {

         val respons=  Network.ImageOfTheDayService.getImageOfTheDay()

       if (respons.isSuccessful){
           _ImageoftheDay.postValue(respons.body())




       }



       }



    }


}