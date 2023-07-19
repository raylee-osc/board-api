package com.boardapp.boardapi.common.config;

import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Configuration
public class JdbcConfig {
    @Value("${spring.datasource.driver-class-name}")
    private String DATABASE_DRIVER_CLASS_NAME;

    @Value("${spring.datasource.url}")
    private String DATABASE_URL;

    @Value("${spring.datasource.username}")
    private String DATABASE_USERNAME;

    @Value("${spring.datasource.password}")
    private String DATABASE_PASSWORD;

    @Bean
    DataSource dataSource() {
        DriverManagerDataSource driverManagerDataSource = new DriverManagerDataSource();

        driverManagerDataSource.setDriverClassName(DATABASE_DRIVER_CLASS_NAME);
        driverManagerDataSource.setUrl(DATABASE_URL);
        driverManagerDataSource.setUsername(DATABASE_USERNAME);
        driverManagerDataSource.setPassword(DATABASE_PASSWORD);

        return driverManagerDataSource;
    }
}
