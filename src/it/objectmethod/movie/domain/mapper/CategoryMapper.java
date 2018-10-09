package it.objectmethod.movie.domain.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import it.objectmethod.movie.domain.AttoriBean;
import it.objectmethod.movie.domain.CategoryBean;
import it.objectmethod.movie.domain.FilmBean;

public class CategoryMapper implements RowMapper<CategoryBean> {
	
	public CategoryBean mapRow(ResultSet resultSet, int i) throws SQLException {
		CategoryBean cb=new CategoryBean();
		cb.setCategoryId(resultSet.getInt("category_id"));
		cb.setName(resultSet.getString("name"));
		return cb;
	}
}
