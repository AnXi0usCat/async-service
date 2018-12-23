package com.mishas.stuff.as.persistence.dao;

import com.mishas.stuff.as.persistence.model.SomeModel;
import io.r2dbc.client.R2dbc;
import io.r2dbc.spi.Connection;
import io.r2dbc.spi.ConnectionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.r2dbc.function.DatabaseClient;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Repository
public class SomeRepository {

    private final DatabaseClient databaseClient;
    private static final Logger logger = LoggerFactory.getLogger(SomeRepository.class.getName());

    @Autowired
    public SomeRepository(DatabaseClient databaseClient) {
        this.databaseClient = databaseClient;
    }

    public void save(SomeModel model) {
        Mono<Integer> count = databaseClient.execute()
                .sql(
                        "INSERT INTO async_audit_trail (id, firstname, surname) VALUES($1, $2, $3)")
                .bind("$1", model.getId())
                .bind("$2", model.getFirstname())
                .bind("$3", model.getSurname())
                .fetch()
                .rowsUpdated();
        count.log().subscribe();
        logger.info("Writing to the database done");
    }

}
