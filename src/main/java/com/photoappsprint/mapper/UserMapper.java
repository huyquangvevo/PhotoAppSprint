package com.photoappsprint.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.photoappsprint.model.User;

public class UserMapper implements RowMapper<User> {
	
	@Override
	public User mapRow(ResultSet rs, int rowNum) throws SQLException {
		User user = new User();
		user.setId(rs.getInt("_id"));
		user.setFirstName(rs.getString("first_name"));
		user.setLastName(rs.getString("last_name"));
		user.setLocation(rs.getString("location"));
		user.setDescription(rs.getString("description"));
		user.setOccupation(rs.getString("occupation"));
		return user;
	}

}
