package com.fs.javalab.webapplication.configuration;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;
import java.beans.PropertyVetoException;

@Configuration
@ComponentScan("com.fs.javalab.webapplication")
public class DataSourceConfiguration {

    @Bean
    public DataSource dataSource() throws PropertyVetoException {
        ComboPooledDataSource dataSource = new ComboPooledDataSource();

        dataSource.setDriverClass("org.apache.derby.jdbc.ClientDriver");
        dataSource.setJdbcUrl("jdbc:derby://localhost:1527/firstdb");
        dataSource.setAutoCommitOnClose(true);
        dataSource.setMaxPoolSize(0);
        dataSource.setAcquireIncrement(0);

        return dataSource;
    }
}
