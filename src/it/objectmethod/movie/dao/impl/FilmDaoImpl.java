package it.objectmethod.movie.dao.impl;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcDaoSupport;

import it.objectmethod.movie.dao.IFilmDao;
import it.objectmethod.movie.domain.AttoriBean;
import it.objectmethod.movie.domain.FilmBean;
import it.objectmethod.movie.domain.mapper.AttoriMapper;
import it.objectmethod.movie.domain.mapper.FilmMapper;

public class FilmDaoImpl extends NamedParameterJdbcDaoSupport implements IFilmDao {
	
	final static String SQL_GET_FILM="select * from film where title like :film";
	final static String SQL_GET_FILM_ACTOR="select f.film_id,f.title,f.description, f.release_year from film_actor fa inner join film f on fa.film_id=f.film_id where fa.actor_id=:attore";
	final static String SQL_GET_FILM_CATEGORY="select f.film_id,f.title,f.description,f.release_year from film f inner join film_category fc on f.film_id=fc.film_id where fc.category_id=:category";

	
	/*private DataSource dataSource;
	private JdbcTemplate jdbcTemplate;
	   
	   public void setDataSource(DataSource dataSource) {
	      this.dataSource = dataSource;
	      this.jdbcTemplate = new JdbcTemplate(dataSource);
	   } */
	   
	   public List<FilmBean> getFilm(String film) {
		   MapSqlParameterSource map = new MapSqlParameterSource();
			map.addValue("film", '%'+film+'%');
		   BeanPropertyRowMapper<FilmBean> rm = new BeanPropertyRowMapper<>(FilmBean.class);
			return getNamedParameterJdbcTemplate().query(SQL_GET_FILM,map, rm);
		}
	   public List<FilmBean> getFilmByActor(String attore) {
		   MapSqlParameterSource map = new MapSqlParameterSource();
			map.addValue("attore", attore);
		   BeanPropertyRowMapper<FilmBean> rm = new BeanPropertyRowMapper<>(FilmBean.class);
		   return getNamedParameterJdbcTemplate().query(SQL_GET_FILM_ACTOR,map, rm);
	   }
	   public List<FilmBean> getFilmByCategory(String category) {
		   MapSqlParameterSource map = new MapSqlParameterSource();
			map.addValue("category", category);
		   BeanPropertyRowMapper<FilmBean> rm = new BeanPropertyRowMapper<>(FilmBean.class);
		   return getNamedParameterJdbcTemplate().query(SQL_GET_FILM_CATEGORY, map, rm);
	   }
}
