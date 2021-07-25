package com.config;

import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;
import javax.xml.crypto.Data;

/**
 * created by: Zhaoliting
 * description: 事务本地配置类
 * created time: 2021/7/18 10:17
 */

public class LocalTransactionalManagerConfig {

	@Bean
	public PlatformTransactionManager platformTransactionManager(DataSource dataSource) {
		return new DataSourceTransactionManager(dataSource);
	} 
	
}
