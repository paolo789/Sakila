package it.objectmethod.movie.domain.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;


import it.objectmethod.movie.domain.AttoriBean;

public class AttoriMapper implements RowMapper<AttoriBean> {
	public AttoriBean mapRow(ResultSet resultSet, int i) throws SQLException {

		AttoriBean attore = new AttoriBean();
		attore.setActorId(resultSet.getInt("actor_id"));
		attore.setFirstName(resultSet.getString("first_name"));
		attore.setLastName(resultSet.getString("last_name"));
	
		return attore;
	}
}
