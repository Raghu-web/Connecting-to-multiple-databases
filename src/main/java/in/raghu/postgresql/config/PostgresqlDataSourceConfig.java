package in.raghu.postgresql.config;

import javax.sql.DataSource;

import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableJpaRepositories(basePackages = "in.raghu.postgres.employeeAddressRepo", 
					   entityManagerFactoryRef = "postgresEntityManagerFactoryBean")
public class PostgresqlDataSourceConfig {

	@ConfigurationProperties("spring.datasource.postgresql")
	@Bean
    DataSourceProperties postgresDataSourceProperties() {
		return new DataSourceProperties();
	}
	
	@Bean
	public DataSource postgresSqlDataSource() {
		return postgresDataSourceProperties().initializeDataSourceBuilder().build();
	}
}
