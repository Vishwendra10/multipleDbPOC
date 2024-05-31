package com.dualdb.dualdbdemo.config;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(
		entityManagerFactoryRef = "entityManagerFactoryBean",
		basePackages = { "com.dualdb.dualdbdemo.mysqlrepo" },
		transactionManagerRef = "transactionManager"
		)
public class MySqlDbConfig {

	@Autowired
	private Environment environment;

	// data soruce

	@Bean
	@Primary
	public DataSource dataSource() {

		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setUrl(environment.getProperty("spring.datasource.url"));
		dataSource.setDriverClassName(environment.getProperty("spring.datasource.driver-class-name"));
		dataSource.setUsername(environment.getProperty("spring.datasource.username"));
		dataSource.setPassword(environment.getProperty("spring.datasource.password"));

		return dataSource;
	}

	// entity manager factory
	
	@Bean(name = "entityManagerFactoryBean")
	@Primary
	public LocalContainerEntityManagerFactoryBean entityManagerFactoryBean() {
		
		LocalContainerEntityManagerFactoryBean bean= new LocalContainerEntityManagerFactoryBean();
		bean.setDataSource(dataSource());
		
		JpaVendorAdapter adapter= new HibernateJpaVendorAdapter();
		
		bean.setJpaVendorAdapter(adapter);
		
		Map<String, String> map = new HashMap<>();
		map.put("hibernate.dialect", "org.hibernate.dialect.MySQLDialect");
		map.put("hibernate.show_sql", "true");
		map.put("hibernate.hbm2ddl.auto", "update");
		
		bean.setJpaPropertyMap(map);
		bean.setPackagesToScan("com.dualdb.dualdbdemo.usermodel");
		
		return bean;
	}

	// platform transaction manager
	
	@Bean(name = "transactionManager")
	@Primary
	public PlatformTransactionManager transactionManager() {
		
		JpaTransactionManager manager= new JpaTransactionManager();
		manager.setEntityManagerFactory(entityManagerFactoryBean().getObject());
		
		return manager;
	}

}
