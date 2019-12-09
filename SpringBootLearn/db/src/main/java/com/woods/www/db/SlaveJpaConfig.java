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
        entityManagerFactoryRef = "slaveLocalContainerEntityManagerFactoryBean",
        transactionManagerRef = "slavePlatformTransactionManager",
        basePackages = {"com.woods.www.db.repo.slave"}
)
public class SlaveJpaConfig {

    @Autowired
    @Qualifier(value = "slaveDataSource")
    DataSource slaveDataSource;

    @Autowired
    JpaProperties jpaProperties;

    @Bean
    LocalContainerEntityManagerFactoryBean slaveLocalContainerEntityManagerFactoryBean(EntityManagerFactoryBuilder builder)
    {
        return builder.dataSource(slaveDataSource)
                .properties(jpaProperties.getProperties())
                .packages("com.woods.www.db.model")
                .persistenceUnit("slave")
                .build();
    }

    @Bean
    PlatformTransactionManager slavePlatformTransactionManager(EntityManagerFactoryBuilder builder)
    {
        LocalContainerEntityManagerFactoryBean localContainerEntityManagerFactoryBean = slaveLocalContainerEntityManagerFactoryBean(builder);
        return new JpaTransactionManager(localContainerEntityManagerFactoryBean.getObject());
    }

}
