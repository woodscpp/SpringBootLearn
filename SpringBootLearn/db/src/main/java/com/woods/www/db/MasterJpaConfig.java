package com.woods.www.db;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.orm.jpa.JpaProperties;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

/**
 * @author: woods
 * @date: 2019/12/8
 * @description:
 */
@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(
        entityManagerFactoryRef = "masterLocalContainerEntityManagerFactoryBean",
        transactionManagerRef = "masterPlatformTransactionManager",
        basePackages = {"com.woods.www.db.repo.master"}
)
public class MasterJpaConfig {

    @Autowired
    @Qualifier(value = "masterDataSource")
    DataSource masterDataSource;

    @Autowired
    JpaProperties jpaProperties;

    @Primary
    @Bean
    LocalContainerEntityManagerFactoryBean masterLocalContainerEntityManagerFactoryBean(EntityManagerFactoryBuilder builder)
    {
        return builder.dataSource(masterDataSource)
                .properties(jpaProperties.getProperties())
                .packages("com.woods.www.db.model")
                .persistenceUnit("master")
                .build();
    }

    @Primary
    @Bean
    PlatformTransactionManager masterPlatformTransactionManager(EntityManagerFactoryBuilder builder)
    {
        LocalContainerEntityManagerFactoryBean localContainerEntityManagerFactoryBean = masterLocalContainerEntityManagerFactoryBean(builder);
        return new JpaTransactionManager(localContainerEntityManagerFactoryBean.getObject());
    }

}
