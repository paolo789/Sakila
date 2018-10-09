package it.objectmethod.movie.dao.impl;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcDaoSupport;

import it.objectmethod.movie.dao.ICategoryDao;
import it.objectmethod.movie.dao.IFilmDao;
import it.objectmethod.movie.domain.CategoryBean;
import it.objectmethod.movie.domain.FilmBean;
import it.objectmethod.movie.domain.mapper.CategoryMapper;
import it.objectmethod.movie.domain.mapper.FilmMapper;

public class CategoryDaoImpl extends NamedParameterJdbcDaoSupport implements ICategoryDao{
	
		
		final static String SQL_GET_CATEGORY="select * from category";
		
		/* private DataSource dataSource;
		private JdbcTemplate jdbcTemplate;
		   
		   public void setDataSource(DataSource dataSource) {
		      this.dataSource = dataSource;
		      this.jdbcTemplate = new JdbcTemplate(dataSource);
		   } */
		   
		   public List<CategoryBean> getCategory() {
			   BeanPropertyRowMapper<CategoryBean> rm = new BeanPropertyRowMapper<>(CategoryBean.class);
				return getJdbcTemplate().query(SQL_GET_CATEGORY, rm);
			}
}
