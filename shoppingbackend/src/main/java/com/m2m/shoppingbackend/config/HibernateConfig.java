package com.m2m.shoppingbackend.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@ComponentScan(value = {"com.m2m.shoppingbackend.dto"})
@EnableTransactionManagement
public class HibernateConfig {
	
	//Change based on the DBMS used.
	private final static String DRIVER_NAME = "org.h2.Driver";
	private final static String DATABASE_URL = "jdbc:h2:~/22-8-20";
	private final static String DATABASE_PASSWORD = "";
	private final static String DATABASE_USER = "sa";
	private final static String DATABASE_DIALECT = "org.hibernate.dialect.H2Dialect";

//---------------------------------------------------------------------
	
	/*
	 * Produce The DataSource Bean.
	 * */
	@Bean
	public DataSource getDataSource() {
		BasicDataSource dataSource = new BasicDataSource();
		
		//Create a data source based on the database properties.
		dataSource.setDriverClassName(DRIVER_NAME);
		dataSource.setUrl(DATABASE_URL);
		dataSource.setUsername(DATABASE_USER);
		dataSource.setPassword(DATABASE_PASSWORD);
		
		
		return dataSource;
	}
	/*
	 * Produce The SessionFactory Bean.
	 * */
	@Bean
	public SessionFactory getSessionFactory(DataSource dataSource) {
		LocalSessionFactoryBuilder builder = new LocalSessionFactoryBuilder(dataSource);
		
		builder.addProperties(getHibernateProperties());
		builder.scanPackages("com.m2m.shoppingbackend.dto");
		
		
		return builder.buildSessionFactory();
	}
	
	//Get The Hibernate Properties
	private Properties getHibernateProperties() {
		Properties properties = new Properties();
		properties.put("hibernate.dialect", DATABASE_DIALECT);
		properties.put("hibernate.show_sql", "true");
		properties.put("hibernate.format_sql", "true");
		
		return properties;
	}
	//--------------------------------------------------------------------------------------
	/*
	 * Produce The TransactionalManager Bean
	 * */
	@Bean
	public HibernateTransactionManager getTransactionalManager(SessionFactory sessionFactory) {
		return new HibernateTransactionManager(sessionFactory);
	}
	
	
	
}
