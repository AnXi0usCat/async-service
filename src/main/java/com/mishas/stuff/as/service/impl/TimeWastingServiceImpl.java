package com.mishas.stuff.as.service.impl;

import com.mishas.stuff.as.service.TimeWastingService;
import com.mishas.stuff.as.web.dto.SomeDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import java.io.UnsupportedEncodingException;
import java.util.UUID;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

@Service
public class TimeWastingServiceImpl implements TimeWastingService {

    private static final Logger logger = LoggerFactory.getLogger(TimeWastingServiceImpl.class.getName());
    private static final String ALPHA_NUMERIC_STRING = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final int WORD_LENGTH = 12;

    @Override
    public CompletableFuture<SomeDto> wasteTime() {
        return CompletableFuture.supplyAsync(() -> {
            SomeDto dto = null;
            try {
                dto = new SomeDto(
                        getId(),
                        getFirstname(),
                        getSurname()
                );
                logger.info("Finished SomeDto Object Creation");
            } catch (InterruptedException | ExecutionException ex) {
                // meow meow
            }
            return dto;
        });
    }

    private CompletableFuture<String> performAsynchronousCalculation() {
        return CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(500);
            } catch (InterruptedException ie) {
                // meow meow
            }
            StringBuilder builder = new StringBuilder();
            int count = WORD_LENGTH;
            while (count-- != 0) {
                int character = (int) (Math.random() * ALPHA_NUMERIC_STRING.length());
                builder.append(ALPHA_NUMERIC_STRING.charAt(character));
            }
            return builder.toString();
        });
    }

    private CompletableFuture<String> getId() {
        return CompletableFuture.supplyAsync(() -> {
            byte[] bytes;
            try {
                logger.info("Going to Sleep for the UUID Calculation");
                String source = performAsynchronousCalculation().get();
                bytes = source.getBytes("UTF-8");
            } catch ( InterruptedException | ExecutionException | UnsupportedEncodingException ee) {
                logger.error("Failed to convert application instance to Bytes");
                throw new RuntimeException("Could not convert ApplicationDto to bytes: " + ee.getMessage());
            }
            String uuid = UUID.nameUUIDFromBytes(bytes).toString();
            logger.info("uuid generated: "+ uuid);
            return uuid;
        });
    }

    private CompletableFuture<String> getFirstname() {
        logger.info("Going to Sleep for the First Name Calculation");
        return performAsynchronousCalculation();
    }

    private CompletableFuture<String> getSurname() {
        logger.info("Going to Sleep for the Surname Calculation");
        return performAsynchronousCalculation();
    }




}
