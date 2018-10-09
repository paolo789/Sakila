package it.objectmethod.movie.domain.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;


import it.objectmethod.movie.domain.AttoriBean;
import it.objectmethod.movie.domain.FilmBean;

public class FilmMapper implements RowMapper<FilmBean> {
	public FilmBean mapRow(ResultSet resultSet, int i) throws SQLException {

		FilmBean film = new FilmBean();
		film.setFilm_id(resultSet.getInt("film_id"));
		film.setTitle(resultSet.getString("title"));
		film.setDescription(resultSet.getString("description"));
		film.setRelease_year(resultSet.getString("release_year"));
	
		return film;
	}
}
