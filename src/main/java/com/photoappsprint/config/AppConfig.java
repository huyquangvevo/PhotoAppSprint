package com.photoappsprint.config;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.web.WebApplicationInitializer;

import com.photoappsprint.dao.CommentDAO;
import com.photoappsprint.dao.PhotoDAO;
import com.photoappsprint.dao.UserDAO;


@Configuration
@PropertySource("classpath:db.properties")
public class AppConfig {
	
	@Autowired
	private Environment env;

	@Bean
	public DriverManagerDataSource dataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName(env.getProperty("mysql.driver"));
		dataSource.setUrl(env.getProperty("mysql.jdbcUrl"));
		dataSource.setUsername(env.getProperty("mysql.username"));
		dataSource.setPassword(env.getProperty("mysql.password"));
		return dataSource;
	}
	
	@Bean
	public UserDAO userDAO() {
		UserDAO userDAO = new UserDAO();
		userDAO.setDataSource(dataSource());
		return userDAO;
	}
	
	@Bean
	public PhotoDAO photoDAO() {
		PhotoDAO photoDAO = new PhotoDAO();
		photoDAO.setDataSource(dataSource());
		return photoDAO;
	}
	
	@Bean
	public CommentDAO commentDAO() {
		CommentDAO commentDAO = new CommentDAO();
		commentDAO.setDataSource(dataSource());
		return commentDAO;
	}

	
	
}
