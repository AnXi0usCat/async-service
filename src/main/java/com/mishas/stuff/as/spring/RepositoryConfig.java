package com.mishas.stuff.as.spring;

import io.r2dbc.postgresql.PostgresqlConnectionConfiguration;
import io.r2dbc.postgresql.PostgresqlConnectionFactory;
import io.r2dbc.spi.ConnectionFactory;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.r2dbc.function.DatabaseClient;


@Configuration
@ComponentScan(value = {"com.mishas.stuff.as.persistence"})
@EntityScan(value = {"com.mishas.stuff.as.persistence.model"})
public class RepositoryConfig {

    public RepositoryConfig() {
        super();
    }

//    @Value("${spring.datasource.db}")
//    private String database;
//    @Value("${spring.datasource.username}")
//    private String username;
//    @Value("${spring.datasource.password}")
//    private String password;
//    @Value("${spring.datasource.host}")
//    private String host;

    @Bean
    public PostgresqlConnectionFactory connectionFactory() {

        PostgresqlConnectionConfiguration config = PostgresqlConnectionConfiguration.builder()
                .database("async_db")
                .host("localhost")
                .port(5432)
                .username("async_service")
                .password("async_password")
                .build();

        return new PostgresqlConnectionFactory(config);
    }

    @Bean
    public DatabaseClient databaseClient() {
        return DatabaseClient.create(connectionFactory());
    }
}
