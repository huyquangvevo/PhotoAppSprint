package com.photoappsprint.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.photoappsprint.model.Photo;

public class PhotoMapper implements RowMapper<Photo> {

	@Override
	public Photo mapRow(ResultSet rs, int rowNum) throws SQLException {
		Photo photo = new Photo();
		photo.setId(rs.getInt("_id"));
//		photo.setUserId(rs.getInt("user_id"));
		photo.setFileName(rs.getString("file_name"));
		photo.setDateTime(rs.getDate("date_time"));
		return photo;
	}
	
}
