package it.objectmethod.movie.dao.impl;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcDaoSupport;

import it.objectmethod.movie.dao.IAttoriDao;
import it.objectmethod.movie.domain.AttoriBean;
import it.objectmethod.movie.domain.CategoryBean;
import it.objectmethod.movie.domain.mapper.AttoriMapper;

public class AttoriDaoImpl extends NamedParameterJdbcDaoSupport implements IAttoriDao{
	
 final static String SQL_GET_ACTOR="select * from actor where last_name like :actor";
 final static String SQL_GET_ACTORS_FILM="select a.actor_id,a.first_name,a.last_name from film_actor fa inner join actor a on fa.actor_id=a.actor_id where fa.film_id=:film";
 
	/*private DataSource dataSource;
	private JdbcTemplate jdbcTemplate;
	   
	   public void setDataSource(DataSource dataSource) {
	      this.dataSource = dataSource;
	      this.jdbcTemplate = new JdbcTemplate(dataSource);
	   } */
	   public List<AttoriBean> getActors(String actor) {
		   MapSqlParameterSource map = new MapSqlParameterSource();
			map.addValue("actor", '%'+actor+'%');
		   BeanPropertyRowMapper<AttoriBean> rm = new BeanPropertyRowMapper<>(AttoriBean.class);
			return getNamedParameterJdbcTemplate().query(SQL_GET_ACTOR,map, rm);
		}
	   public List<AttoriBean> getActorsByFilm(String film) {
		   MapSqlParameterSource map = new MapSqlParameterSource();
			map.addValue("film", film);
		   BeanPropertyRowMapper<AttoriBean> rm = new BeanPropertyRowMapper<>(AttoriBean.class);
		    return getNamedParameterJdbcTemplate().query(SQL_GET_ACTORS_FILM,map, rm);
	   }
}
