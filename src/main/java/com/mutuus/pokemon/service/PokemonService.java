package com.mutuus.pokemon.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.web.client.RestTemplate;

import com.mutuus.pokemon.entity.Pokemon;

public class PokemonService {
	
	private static String APIURL = "https://pokeapi.co/api/v2";
	private RestTemplate builder;
	private static final Logger log = LoggerFactory.getLogger(PokemonService.class);
	
	public PokemonService(RestTemplateBuilder templateBuilder) {
		this.builder = templateBuilder.build();
	}

	public String getAll(Integer limit, Integer offet) {
		String list = builder.getForObject(APIURL+"/pokemon/?limit="+limit+"&offset=" + offet, String.class);
		log.info("RESULT: "+list.toString());
		return list;
	}
	
	public Pokemon getById(Integer id) {
		Pokemon object = builder.getForObject(APIURL+"/pokemon/"+id, Pokemon.class);
		log.info("RESULT: "+object.toString());
		return object;
	}
	
}
