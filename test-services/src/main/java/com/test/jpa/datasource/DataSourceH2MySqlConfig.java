package com.test.jpa.datasource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
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
        basePackages = {DataSourceH2MySqlConfig.COM_TEST_REPOSITORIES_MYSQL},
        entityManagerFactoryRef = "h2mysqlEntityManager",
        transactionManagerRef = "h2mysqlTransactionManager")
@EnableTransactionManagement
@Profile("testh2")
public class DataSourceH2MySqlConfig extends BaseH2Config {

    public static final String COM_TEST_REPOSITORIES_MYSQL = "com.test.jpa.repositories.h2mysql";
    public static final String COM_TEST_MODEL_MYSQL = "com.test.jpa.model.h2mysql";

    @Autowired
    private Environment env;

    @Bean
    @Primary
    public LocalContainerEntityManagerFactoryBean h2mysqlEntityManager() {
        return super.entityManager(env, DataSourceH2MySqlConfig.COM_TEST_MODEL_MYSQL);
    }

    @Bean
    @Primary
    public PlatformTransactionManager h2mysqlTransactionManager() {
        JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(h2mysqlEntityManager().getObject());
        return transactionManager;
    }
}
