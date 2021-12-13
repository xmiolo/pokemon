package com.mutuus.pokemon.dao;

import java.util.List;

import com.mutuus.pokemon.entity.Pokemon;

public interface PokemonDAO {
	List<Pokemon> getAll();
	
	Pokemon findById(Long id);

	void saveOrUpdate(Pokemon pokemon);

	void delete(Pokemon pokemon);

}
