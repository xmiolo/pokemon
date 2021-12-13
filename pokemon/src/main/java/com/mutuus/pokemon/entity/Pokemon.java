package com.mutuus.pokemon.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

import org.springframework.hateoas.RepresentationModel;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
@Entity
public class Pokemon extends RepresentationModel<Pokemon> {
	
	private Integer id;	
	@Id
	private String name;
	private String url;

	
	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getUrl() {
		return url;
	}


	public void setUrl(String url) {
		this.url = url;
	}


	public Pokemon(Integer id, String name, String url) {
		super();
		this.id = id;
		this.name = name;
		this.url = url;
	}
	
	public Pokemon() {
		super();
	}


	@Override
	public String toString() {
		return "Pokemon [id=" + id + ", name=" + name + ", url=" + url + "]";
	}
		
}
