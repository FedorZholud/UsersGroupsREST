package com.zholud.usersgroupsrest.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.EntityManagerFactory;
import java.util.Properties;

@Configuration
@EnableTransactionManagement
@PropertySource({ "classpath:postgresql.properties" })
@ComponentScan({ "com.zholud.usersgroupsrest" })
public class DatabaseConfig {

    @Autowired
    private Environment env;

    Properties hibernateProperties() {
        return new Properties() {
            {
                setProperty("hibernate.hbm2ddl.auto",
                        env.getProperty("hibernate.hbm2ddl.auto"));
                setProperty("hibernate.dialect",
                        env.getProperty("hibernate.dialect"));
                setProperty("hibernate.globally_quoted_identifiers",
                        "true");
            }
        };
    }

    @Bean
    public DriverManagerDataSource getDataSource() {

        DriverManagerDataSource bds = new DriverManagerDataSource();
        bds.setDriverClassName("org.postgresql.Driver");
        bds.setUrl("jdbc:postgresql://localhost:5432/usersgroups");
        bds.setUsername("postgres");
        bds.setPassword("ejvekfm7");

        return bds;
    }

    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
        //JpaVendorAdapteradapter can be autowired as well if it's configured in application properties.
        HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
        vendorAdapter.setGenerateDdl(false);

        LocalContainerEntityManagerFactoryBean factory = new LocalContainerEntityManagerFactoryBean();
        factory.setJpaVendorAdapter(vendorAdapter);
        //Add package to scan for entities.
        factory.setPackagesToScan("com.zholud.usersgroupsrest");
        factory.setDataSource(this.getDataSource());
        factory.setJpaProperties(hibernateProperties());
        return factory;
    }

    @Bean
    public PlatformTransactionManager transactionManager(EntityManagerFactory entityManagerFactory) {
        JpaTransactionManager txManager = new JpaTransactionManager();
        txManager.setEntityManagerFactory(entityManagerFactory);
        return txManager;
    }
}