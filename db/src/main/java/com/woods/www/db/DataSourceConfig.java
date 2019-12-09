package com.woods.www.db;

import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;

/**
 * @author: woods
 * @date: 2019/12/8
 * @description:
 */
@Configuration
public class DataSourceConfig {
//
//    /**
//     *     master库
//     */
//    @Primary
//    @Bean(name = "masterDataSourceProperties")
//    @Qualifier("masterDataSourceProperties")
//    @ConfigurationProperties(prefix = "spring.datasource.master")
//    public DataSourceProperties masterDataSourceProperties(){
//        return new DataSourceProperties();
//    }
//
//    @Primary
//    @Bean
//    @Qualifier
//    public DataSource masterDataSource(@Qualifier("masterDataSourceProperties") DataSourceProperties dataSourceProperties)
//    {
//        return dataSourceProperties.initializeDataSourceBuilder().build();
//    }
//
//    /**
//     * slave 库
//     */
//    @Bean(name = "slaveDataSourceProperties")
//    @Qualifier("slaveDataSourceProperties")
//    @ConfigurationProperties(prefix = "spring.datasource.slave")
//    public DataSourceProperties slaveDataSourceProperties(){
//        return new DataSourceProperties();
//    }
//
//    @Bean(name = "slaveDataSource")
//    @Qualifier("slaveDataSource")
//    public DataSource slaveDataSource(@Qualifier("slaveDataSourceProperties") DataSourceProperties dataSourceProperties)
//    {
//        return dataSourceProperties.initializeDataSourceBuilder().build();
//    }

    @Primary
    @Bean
    @ConfigurationProperties(prefix = "spring.datasource.master")
    DataSource masterDataSource(){
        return DruidDataSourceBuilder.create().build();
//        return DruidDataSourceBuilder.create().build(env, "spring.datasource.master");
    }

    @Bean
    @ConfigurationProperties(prefix = "spring.datasource.slave")
    DataSource slaveDataSource(){
        return DruidDataSourceBuilder.create().build();
//        return DruidDataSourceBuilder.create().build(env, "spring.datasource.slave");
    }
}
