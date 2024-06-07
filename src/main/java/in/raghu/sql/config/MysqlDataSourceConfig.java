package in.raghu.sql.config;

import javax.sql.DataSource;

import org.hibernate.jpa.boot.spi.EntityManagerFactoryBuilder;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;

@Configuration
@EnableJpaRepositories(basePackages = "in.raghu.sql.EmployeeRepo",
					entityManagerFactoryRef = "mySqlEntityManagerFactoryBean")

public class MysqlDataSourceConfig {
	
	@ConfigurationProperties("spring.datasource.mysql")
	@Bean
	DataSourceProperties mysqlDataSourceProperties() {
		return new DataSourceProperties();
	}
	/*
	@Bean
	public DataSource mysqlDataSource() {
		DriverManagerDataSource dataSource=new DriverManagerDataSource();
		dataSource.setUsername(mysqlDataSourceProperties().getUsername());
		dataSource.setPassword(mysqlDataSourceProperties().getPassword());
		dataSource.setDriverClassName(mysqlDataSourceProperties().getDriverClassName());
		dataSource.setUrl(mysqlDataSourceProperties().getUrl());
		return dataSource;
	}
	*/
	
	@Bean
	DataSource mysqlDataSource() {
		return mysqlDataSourceProperties().initializeDataSourceBuilder().build();
	}

}
