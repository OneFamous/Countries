package com.fatihates.countries.view

import android.view.LayoutInflater
import androidx.recyclerview.widget.RecyclerView
import com.fatihates.countries.model.Country
import android.view.ViewGroup
import com.fatihates.countries.databinding.ItemCountryBinding


class CountryListAdapter(var countries: ArrayList<Country>): RecyclerView.Adapter<CountryListAdapter.CountryViewHolder>() {

    fun updateCountries(newCountries: List<Country>){
        countries.clear()
        countries.addAll(newCountries)
        notifyDataSetChanged()
    }

    class CountryViewHolder(binding: ItemCountryBinding): RecyclerView.ViewHolder(binding.root){

        private val countryName = binding.name

        fun bind(country: Country){
            countryName.text = country.countryName
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int)= CountryViewHolder(
        ItemCountryBinding.inflate(LayoutInflater.from(parent.context), parent, false)
    )

    override fun getItemCount() = countries.size

    override fun onBindViewHolder(holder: CountryViewHolder, position: Int) {
     holder.bind(countries[position])
    }
}