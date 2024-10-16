package com.example.listapokemons


import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.listapokemons.databinding.ActivityPokemonDetailBinding
import com.example.listapokemons.ui.main.PokemonImagesAdapter

class PokemonDetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityPokemonDetailBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Vinculando o layout usando o ViewBinding
        binding = ActivityPokemonDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Receber os dados enviados via Intent
        val pokemonName = intent.getStringExtra("POKEMON_NAME")
        val pokemonImages = listOf(
            intent.getStringExtra("POKEMON_IMAGE_URL") ?: "",
            // Adicione outras URLs de imagens, se tiver
        )

        // Atribuir o nome ao TextView
        binding.pokemonNameDetail.text = pokemonName

        // Configuração do RecyclerView para exibir a lista de imagens
        binding.pokemonImagesRecyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        binding.pokemonImagesRecyclerView.adapter = PokemonImagesAdapter(pokemonImages)
    }
}
