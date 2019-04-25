package com.test.jpa.datasource;

import javax.sql.DataSource;
import java.util.HashMap;

import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;

public class BaseH2Config {

    protected LocalContainerEntityManagerFactoryBean entityManager(Environment env, String packageScan) {
        LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
        em.setDataSource(dataSourceH2(env));
        em.setPackagesToScan(packageScan);

        HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
        em.setJpaVendorAdapter(vendorAdapter);
        HashMap<String, Object> properties = new HashMap<>();

        properties.put("hibernate.hbm2ddl.auto", env.getProperty("hibernate.hbm2ddl.auto.h2"));
        properties.put("hibernate.dialect", env.getProperty("spring.jpa.properties.hibernate.dialect.h2"));

        em.setJpaPropertyMap(properties);
        return em;
    }

    protected DataSource dataSourceH2(Environment env) {

        DriverManagerDataSource dataSource = new DriverManagerDataSource();

        dataSource.setDriverClassName(env.getProperty("app.datasource.h2.driver"));
        dataSource.setUrl(env.getProperty("app.datasource.h2.url"));
        dataSource.setUsername(env.getProperty("app.datasource.h2.username"));
        dataSource.setPassword(env.getProperty("app.datasource.h2.password"));

        return dataSource;
    }
}
