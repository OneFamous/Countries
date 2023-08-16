package com.fatihates.countries.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.fatihates.countries.model.Country

class ListViewModel: ViewModel(){

    val countries = MutableLiveData<List<Country>>()
    val countryLoadError = MutableLiveData<Boolean>()
    val loading = MutableLiveData<Boolean>()

    fun refresh(){
        fetchCountries()
    }

    private fun fetchCountries(){
    val mockData = listOf(Country("Country a"),
        Country("Country b"),
        Country("Country c"),
        Country("Country d"),
        Country("Country e"),
        Country("Country f"),
        Country("Country h"),
        Country("Country i"),
        Country("Country j"),
        Country("Country k"),
        Country("Country l"),
    )
        countryLoadError.value=false
        loading.value = false
        countries.value = mockData
    }
}