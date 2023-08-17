package com.fatihates.countries.view

import android.view.LayoutInflater
import androidx.recyclerview.widget.RecyclerView
import com.fatihates.countries.model.Country
import android.view.ViewGroup
import com.fatihates.countries.databinding.ItemCountryBinding
import com.fatihates.countries.util.getProgressDrawable
import com.fatihates.countries.util.loadImage


class CountryListAdapter(var countries: ArrayList<Country>): RecyclerView.Adapter<CountryListAdapter.CountryViewHolder>() {

    fun updateCountries(newCountries: List<Country>){
        countries.clear()
        countries.addAll(newCountries)
        notifyDataSetChanged()
    }

    class CountryViewHolder(binding: ItemCountryBinding): RecyclerView.ViewHolder(binding.root){

        private val countryName = binding.name
        private val imageView = binding.imageView
        private val countryCapital = binding.capital
        private val progressDrawable = getProgressDrawable(binding.root.context)
        fun bind(country: Country){
            countryName.text = country.countryName
            countryCapital.text = country.capital
            imageView.loadImage(country.flag, progressDrawable)
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