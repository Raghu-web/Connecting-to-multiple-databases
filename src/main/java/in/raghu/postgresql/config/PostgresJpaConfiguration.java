package in.raghu.postgresql.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.jpa.HibernatePersistenceProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@EnableTransactionManagement
@Configuration
@EnableJpaRepositories(
						entityManagerFactoryRef = "postgresEntityManagerFactoryBean",
						transactionManagerRef = "postgresTransactionManager")
public class PostgresJpaConfiguration{
	
	@Autowired
	public DataSource postgresSqlDataSource;
	
	@Bean
    LocalContainerEntityManagerFactoryBean postgresEntityManagerFactoryBean() {
        LocalContainerEntityManagerFactoryBean entityManagerFactoryBean = new LocalContainerEntityManagerFactoryBean();
        entityManagerFactoryBean.setDataSource(postgresSqlDataSource);
        entityManagerFactoryBean.setPackagesToScan("in.raghu.postgres.entity");
        entityManagerFactoryBean.setPersistenceProviderClass(HibernatePersistenceProvider.class);
        //entityManagerFactoryBean.setPersistenceUnitName("in.raghu.postgres.entity");
        
        //Properties jpaProperties = new Properties();
        //jpaProperties.put("hibernate.dialect", "org.hibernate.dialect.PostgreSQL94Dialect");
        //
        
        //entityManagerFactoryBean.setJpaProperties(jpaProperties);

        return entityManagerFactoryBean;
	}
	
	@Bean
	PlatformTransactionManager postgresTransactionManager(@Qualifier("postgresEntityManagerFactoryBean") LocalContainerEntityManagerFactoryBean localContainerEntityManagerFactoryBean) {
		return new JpaTransactionManager(localContainerEntityManagerFactoryBean.getObject());
	}

}