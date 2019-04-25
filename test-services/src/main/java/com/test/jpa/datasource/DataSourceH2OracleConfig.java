package com.test.jpa.datasource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @author syduch
 */

@Configuration
@EnableJpaRepositories(
        basePackages = {DataSourceH2OracleConfig.COM_TEST_REPOSITORIES_ORACLE},
        entityManagerFactoryRef = "oracleEntityManager",
        transactionManagerRef = "oracleTransactionManager")
@EnableTransactionManagement
@Profile("testh2")
public class DataSourceH2OracleConfig extends BaseH2Config {

    public static final String COM_TEST_REPOSITORIES_ORACLE = "com.test.jpa.repositories.oracle";
    public static final String COM_TEST_MODEL_ORACLE = "com.test.jpa.model.oracle";

    @Autowired
    private Environment env;

    @Bean
    public LocalContainerEntityManagerFactoryBean oracleEntityManager() {

        return super.entityManager(env, DataSourceH2OracleConfig.COM_TEST_MODEL_ORACLE);
    }

    @Bean
    public PlatformTransactionManager oracleTransactionManager() {
        JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(oracleEntityManager().getObject());
        return transactionManager;
    }
}
