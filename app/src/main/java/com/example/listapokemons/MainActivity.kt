package com.example.listapokemons

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import com.example.listapokemons.data.PokemonRepository
import com.example.listapokemons.data.api.ApiClient
import com.example.listapokemons.databinding.ActivityMainBinding
import com.example.listapokemons.ui.main.MainListAdapter
import com.example.listapokemons.ui.main.MainViewModel
import com.example.listapokemons.ui.pokemonlist.MainViewModelFactory


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val viewModel: MainViewModel by viewModels {
        MainViewModelFactory(PokemonRepository(ApiClient.createPokeApiService()))
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Configuração do adaptador
        val adapter = MainListAdapter { view, pokemon ->
            val intent = Intent(this, PokemonDetailActivity::class.java)
            intent.putExtra("POKEMON_NAME", pokemon.name)
            intent.putExtra("POKEMON_IMAGE_URL", pokemon.imageUrl)
            startActivity(intent)
        }

        // Configuração do RecyclerView
        binding.pokemonRecyclerView.layoutManager = GridLayoutManager(this, 3)
        binding.pokemonRecyclerView.adapter = adapter

        // Observar a lista de pokémons e submeter os dados ao adaptador
        viewModel.pokemonList.observe(this) {
            adapter.submitData(lifecycle, it)
        }
    }
}
