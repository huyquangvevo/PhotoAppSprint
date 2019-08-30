package com.photoappsprint.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.photoappsprint.model.Comment;
import com.photoappsprint.model.User;

public class CommentMapper implements RowMapper<Comment>{

	@Override
	public Comment mapRow(ResultSet rs, int rowNum) throws SQLException {
		Comment comment = new Comment();
		comment.setId(rs.getInt("_id"));
//		comment.setPhotoId(rs.getInt("photo_id"));
		comment.setDateTime(rs.getDate("date_time"));
		comment.setUser(new User());
		comment.getUser().setId(rs.getInt("user_id"));
		comment.setComment(rs.getString("comment"));
		return comment;
	}
	
}
