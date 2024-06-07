package in.raghu.sql.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.jpa.HibernatePersistenceProvider;
import org.hibernate.jpa.boot.spi.EntityManagerFactoryBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;

import jakarta.transaction.TransactionManager;

@Configuration
@EnableJpaRepositories(
		entityManagerFactoryRef = "mySqlEntityManagerFactoryBean",
		transactionManagerRef = "mysqlTransactionManager")

public class MysqlJpaConfiguaration {
	
	@Autowired
	public DataSource mysqlDataSource;
	
	@Bean
    LocalContainerEntityManagerFactoryBean mySqlEntityManagerFactoryBean() {
        LocalContainerEntityManagerFactoryBean entityManagerFactoryBean = new LocalContainerEntityManagerFactoryBean();
        entityManagerFactoryBean.setDataSource(mysqlDataSource);
        entityManagerFactoryBean.setPackagesToScan("in.raghu.sql.entity");
        entityManagerFactoryBean.setPersistenceProviderClass(HibernatePersistenceProvider.class);
        //entityManagerFactoryBean.setPersistenceUnitName("in.raghu.sql.entity");
        
        Properties jpaProperties = new Properties();
        jpaProperties.put("hibernate.dialect", "org.hibernate.dialect.MySQLDialect");
        entityManagerFactoryBean.setJpaProperties(jpaProperties);

        return entityManagerFactoryBean;
	}
	
	@Bean
	PlatformTransactionManager mysqlTransactionManager(@Qualifier("mySqlEntityManagerFactoryBean") LocalContainerEntityManagerFactoryBean localContainerEntityManagerFactoryBean) {
		return new JpaTransactionManager(localContainerEntityManagerFactoryBean.getObject());
	}

}
