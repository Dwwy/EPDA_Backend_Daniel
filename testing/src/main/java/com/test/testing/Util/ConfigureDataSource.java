package com.test.testing.Util;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.hibernate.jpa.boot.spi.EntityManagerFactoryBuilder;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;


@Configuration
//@EntityScan(basePackages = { "com.test.testing.Model" })
//
//@EnableJpaRepositories(
//        entityManagerFactoryRef = "dbEntityManagerFact.",
//        transactionManagerRef = "dbTransactionManager",
//        basePackages = "com.test.testing.Dao"
//)

public class ConfigureDataSource {
    @Value("${app.db.postgres.url}")
    private String url;
    @Value("${app.db.postgres.username}")
    private String username;
    @Value("${app.db.postgres.password}")
    private String password;
    @Value("${app.db.postgres.driver-class-name}")
    private String driver;
/*    @Bean(name = "source")
    public DataSource getDataSource(){
        DataSourceBuilder dataSourceBuilder = DataSourceBuilder.create();
        dataSourceBuilder.driverClassName(driver);
        dataSourceBuilder.url(url);
        dataSourceBuilder.username(username);
        dataSourceBuilder.password(password);
        return dataSourceBuilder.build();
    }*/
    @Bean (name = "emf")
    public EntityManagerFactory getEntityManager(){
        Map<String, String> configOverrides = new HashMap<>();
//        configOverrides.put("javax.persistence.jdbc.url", "jdbc:postgresql://localhost:5432");
//        configOverrides.put("javax.persistence.jdbc.user", "postgres");
//        configOverrides.put("javax.persistence.jdbc.password", "Dwwy011226@");
//        configOverrides.put("javax.persistence.jdbc.driver", "org.postgresql.Driver");
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("Postgres_DB", configOverrides);
        return emf;
    }
/*    @Bean(name = "dbEntityManagerFact.")
    public LocalContainerEntityManagerFactoryBean db1EntityMgrFactory(
            DataSource dataSource) {
        LocalContainerEntityManagerFactoryBean em
                = new LocalContainerEntityManagerFactoryBean();
        em.setDataSource(dataSource);
        em.setPackagesToScan(new String[]{"com.test.testing.Model"});
        em.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
        Properties properties = new Properties();
        properties.setProperty("hibernate.globally_quoted_identifiers", "true");
        properties.setProperty("hibernate.globally_quoted_identifiers_skip_column_definitions", "true");
        properties.setProperty("hibernate.show_sql", "true");
        properties.setProperty("hibernate.use_sql_comments", "true");
        properties.setProperty("hibernate.format_sql", "true");
        properties.setProperty("hibernate.hbm2ddl.auto", "create");
        em.setJpaProperties(properties);
        return em;
    }
    @Bean(name = "dbTransactionManager")
    public PlatformTransactionManager userTransactionManager(DataSource dataSource) {

        JpaTransactionManager transactionManager
                = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(
                db1EntityMgrFactory(dataSource).getObject());
        return transactionManager;
    }*/
//    @Bean(name = "jdbctemplate")
//    public JdbcTemplate jdbcTemplate(DataSource source){
//        return new JdbcTemplate(source);
//    }
}
