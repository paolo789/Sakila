package it.objectmethod.movie.dao;

import java.util.List;

import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestParam;

import it.objectmethod.movie.domain.FilmBean;

public interface IFilmDao {
	public List<FilmBean> getFilm(String film);
	public List<FilmBean> getFilmByActor(String attore);
	public List<FilmBean> getFilmByCategory(String category);
}
