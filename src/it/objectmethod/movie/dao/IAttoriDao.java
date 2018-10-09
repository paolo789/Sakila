package it.objectmethod.movie.dao;

import java.util.List;

import it.objectmethod.movie.domain.AttoriBean;

public interface IAttoriDao {
	public List<AttoriBean> getActors(String actor);
	public List<AttoriBean> getActorsByFilm(String film);
}
