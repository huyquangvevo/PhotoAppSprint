package com.photoappsprint.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import com.photoappsprint.mapper.PhotoMapper;
import com.photoappsprint.model.Photo;

public class PhotoDAO extends JdbcDaoSupport{

	@Autowired
	CommentDAO commentDAO;
	
	public List<Photo> getPhotoOfUser(int user_id){
		String sql = "SELECT * FROM photo WHERE user_id=?";
		List<Photo> listPhoto = this.getJdbcTemplate().query(sql,new Object[] {user_id},new PhotoMapper());
		for (Photo photo : listPhoto) {
			photo.setComments(commentDAO.getCommentOfPhoto(photo.getId()));
		}
		return listPhoto;
	}
	
}
