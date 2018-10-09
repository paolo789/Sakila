package it.objectmethod.movie.dao;

import java.util.List;

import it.objectmethod.movie.domain.CategoryBean;

public interface ICategoryDao {
	public List<CategoryBean> getCategory();
}
