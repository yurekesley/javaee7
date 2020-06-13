package br.com.caelum;

import java.util.Properties;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabase;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
public class JpaConfigurator {

    @Bean
    public DataSource dataSource() {

	EmbeddedDatabaseBuilder builder = new EmbeddedDatabaseBuilder();
	EmbeddedDatabase db = builder
		.setType(EmbeddedDatabaseType.H2)
		.setName("lojadb")
		.setScriptEncoding("UTF-8")
		.ignoreFailedDrops(true)
		.build();
	return db;
    }

    @Bean
    public LocalContainerEntityManagerFactoryBean getEntityManagerFactory(DataSource dataSource) {
	LocalContainerEntityManagerFactoryBean entityManagerFactory = new LocalContainerEntityManagerFactoryBean();

	entityManagerFactory.setPackagesToScan("br.com.caelum");
	entityManagerFactory.setDataSource(dataSource);

	entityManagerFactory
		.setJpaVendorAdapter(new HibernateJpaVendorAdapter());

	Properties props = new Properties();

	props.setProperty("hibernate.dialect", "org.hibernate.dialect.H2Dialect");
	props.setProperty("hibernate.show_sql", "true");
	props.setProperty("hibernate.hbm2ddl.auto", "create-drop");

	entityManagerFactory.setJpaProperties(props);
	return entityManagerFactory;
    }

    @Bean
    public JpaTransactionManager getTransactionManager(EntityManagerFactory emf) {
	JpaTransactionManager transactionManager = new JpaTransactionManager();
	transactionManager.setEntityManagerFactory(emf);

	return transactionManager;
    }

}
