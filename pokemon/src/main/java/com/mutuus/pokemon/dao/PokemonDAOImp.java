package com.mutuus.pokemon.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mutuus.pokemon.entity.Pokemon;

@Repository
public class PokemonDAOImp implements PokemonDAO{

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public Pokemon findById(Long id) {
		return sessionFactory.getCurrentSession().get(Pokemon.class, id);
	}

	@Override
	public void saveOrUpdate(Pokemon pokemon) {
		sessionFactory.getCurrentSession().save(pokemon);
	}

	@Override
	public void delete(Pokemon pokemon) {
		sessionFactory.getCurrentSession().delete(pokemon);
	}

	@Override
	public List<Pokemon> getAll() {
		return sessionFactory.getCurrentSession().createQuery("FROM "+Pokemon.class.getSimpleName()).getResultList();
	}

}
