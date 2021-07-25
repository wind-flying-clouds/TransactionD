package com.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.jdbc.support.lob.DefaultLobHandler;
import org.springframework.jdbc.support.lob.LobHandler;

import javax.sql.DataSource;

/**
 * created by: Zhaoliting
 * description:
 * created time: 2021/6/22 23:46
 */

public class JdbcConfig {


	@Value("${jdbc.driver}")
	private String driverClass;

	@Value("${jdbc.url}")
	private String url;

	@Value("${jdbc.username}")
	private String userName;

	@Value("${jdbc.password}")
	private String password;
	

	@Bean("dataSource")
	public DataSource createDataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName(driverClass);
		dataSource.setUrl(url);
		dataSource.setUsername(userName);
		dataSource.setPassword(password);
		// dataSource.setDriverClassName(driver);
		return dataSource;
	}


	@Bean("jdbcTemplate")
	public JdbcTemplate createJdbcTemplate(@Autowired DataSource dataSource) {
		return new JdbcTemplate(dataSource);
	}


	@Bean("lobHandler")
	public LobHandler createLoadHandler() {
		return new DefaultLobHandler();
	} 
	
	
	
}
