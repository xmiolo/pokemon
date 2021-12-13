package com.mutuus.pokemon.controller;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.mutuus.pokemon.dao.PokemonDAOImp;
import com.mutuus.pokemon.entity.Pokemon;
import com.mutuus.pokemon.service.PokemonService;

@RestController
@RequestMapping("api/pokemon")
public class PokemonController {
	
	@Autowired
	private PokemonDAOImp pokemonDao;
	private PokemonService pokemonService;
	
	public PokemonController(RestTemplateBuilder builder) {
		this.pokemonService = new PokemonService(builder);
	}

	/**
	 * Retorna a lista de Pokemons de pokemons paginada
	 * @param limit
	 * @param offet
	 * @return
	 */
	@GetMapping
	public Pokemon[] getAll(
			@RequestParam(defaultValue = "0", name="offset") Integer offset,
			@RequestParam(defaultValue = "100", name="limit") Integer limit) {
		
		//List<Pokemon> dbList = pokemonDao.getAll();
		Pokemon[] objects = null;
		String json = pokemonService.getAll(limit, offset);
		
		
		ObjectMapper mapper = new ObjectMapper();
		try {
			JsonNode rootNode = mapper.readTree(json);
			
			if (rootNode.get("results") instanceof ArrayNode) {
				mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
				objects = mapper.readValue(rootNode.get("results").toString(), Pokemon[].class);
				/*for(Pokemon poke : objects) {
					pokemonDao.saveOrUpdate(poke);
				}*/
			} 
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		return objects;
	}
	
	
	/**
	 * Retorna Pokemons por ID
	 * @param id
	 * @return
	 */
	@GetMapping("/{id}")
	public Pokemon getById(@PathVariable Integer id) {
		Pokemon pokeReturn = pokemonService.getById(id);
		pokeReturn.add(linkTo(methodOn(PokemonController.class)
				.getById(id)).withSelfRel());
		return pokeReturn;
	}
	
}
