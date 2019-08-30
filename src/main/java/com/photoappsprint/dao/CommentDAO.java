package com.photoappsprint.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import com.photoappsprint.mapper.CommentMapper;
import com.photoappsprint.mapper.UserMapper;
import com.photoappsprint.model.Comment;

public class CommentDAO extends JdbcDaoSupport {
	
	@Autowired
	UserDAO userDAO;
	
	public List<Comment> getCommentOfPhoto(int photo_id){
		String sql = "SELECT * FROM comment WHERE photo_id=?";
		List<Comment> listComments = this.getJdbcTemplate().query(sql, new Object[] {photo_id}, new CommentMapper());
		for (Comment comment : listComments) {
			comment.setUser(userDAO.userModel(comment.getUser().getId()));
		}
		return listComments;
	} 

}
