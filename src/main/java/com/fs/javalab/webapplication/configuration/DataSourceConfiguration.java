package com.fs.javalab.webapplication.configuration;

import org.apache.commons.dbcp2.BasicDataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import java.beans.PropertyVetoException;

@Configuration
@ComponentScan("com.fs.javalab.webapplication")
public class DataSourceConfiguration {

    @Bean
    public DataSource dataSource() throws PropertyVetoException {
        BasicDataSource dataSource = new BasicDataSource();

        dataSource.setDriverClassName("org.apache.derby.jdbc.ClientDriver");
        dataSource.setUrl("jdbc:derby://localhost:1527/firstdb");
        dataSource.setDefaultAutoCommit(true);
        dataSource.setInitialSize(5);
        dataSource.setMaxTotal(5);
        dataSource.setMaxWaitMillis(30000);

        return dataSource;
    }
}
