package com.fs.javalab.webapplication.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

@Configuration
@ComponentScan("com.fs.javalab.webapplication")
public class DataSourceConfiguration {

    @Bean
    public DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();

        dataSource.setDriverClassName("org.apache.derby.jdbc.ClientDriver");
        dataSource.setUrl("jdbc:derby://localhost:1527/firstdb");

        return dataSource;
    }
}
