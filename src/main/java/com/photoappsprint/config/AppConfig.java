package com.photoappsprint.config;

import java.util.Properties;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.photoappsprint.model.Comment;
import com.photoappsprint.model.Photo;
import com.photoappsprint.model.User;


@Configuration
@PropertySource("classpath:db.properties")
@EnableTransactionManagement
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
	
//	@Bean
//	public UserDAO userDAO() {
//		UserDAO userDAO = new UserDAO();
//		userDAO.setDataSource(dataSource());
//		return userDAO;
//	}
//	
//	@Bean
//	public PhotoDAO photoDAO() {
//		PhotoDAO photoDAO = new PhotoDAO();
//		photoDAO.setDataSource(dataSource());
//		return photoDAO;
//	}
//	
//	@Bean
//	public CommentDAO commentDAO() {
//		CommentDAO commentDAO = new CommentDAO();
//		commentDAO.setDataSource(dataSource());
//		return commentDAO;
//	}

	@Bean
	public LocalSessionFactoryBean sessionFactory() {
		/*org.hibernate.cfg.Configuration configuration = new org.hibernate.cfg.Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Photo.class)
				.addAnnotatedClass(User.class)
				.addAnnotatedClass(Comment.class);
		SessionFactory sessionFactory = configuration.buildSessionFactory();*/
		LocalSessionFactoryBean factoryBean = new LocalSessionFactoryBean();
		Properties props = new Properties();
		
		props.put("hibernate.dialect", env.getProperty("hibernate.dialect"));
		props.put("show_sql", env.getProperty("show_sql"));
		props.put("hbm2ddl.auto", env.getProperty("hibernate.hbm2ddl_auto"));
		
		factoryBean.setDataSource(dataSource());
		factoryBean.setHibernateProperties(props);
		factoryBean.setPackagesToScan("com.photoappsprint.model");
		
		return factoryBean;
	}
	
	@Bean
	public PlatformTransactionManager hibernateTransactionManager() {
		HibernateTransactionManager hTransactionManager = new HibernateTransactionManager();
		hTransactionManager.setSessionFactory(sessionFactory().getObject());
		return hTransactionManager;
	}
}
