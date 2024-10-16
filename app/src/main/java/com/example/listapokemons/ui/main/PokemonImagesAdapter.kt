package com.example.listapokemons.ui.main

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.listapokemons.databinding.PokemonImageItemBinding

class PokemonImagesAdapter(private val images: List<String>) : RecyclerView.Adapter<PokemonImagesAdapter.ImageViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ImageViewHolder {
        val binding = PokemonImageItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ImageViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ImageViewHolder, position: Int) {
        val imageUrl = images[position]
        Glide.with(holder.binding.pokemonImage.context)
            .load(imageUrl)
            .into(holder.binding.pokemonImage)
    }

    override fun getItemCount(): Int = images.size

    inner class ImageViewHolder(val binding: PokemonImageItemBinding) : RecyclerView.ViewHolder(binding.root)
}