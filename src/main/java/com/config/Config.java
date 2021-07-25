package com.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * created by: Zhaoliting
 * description:
 * created time: 2021/6/22 23:40 
 */

@Configuration
@Import({JdbcConfig.class,LocalTransactionalManagerConfig.class})
@ComponentScan("com.forever")
@PropertySource("classpath:jdbc.properties")
@EnableTransactionManagement
public class Config {
}
