package com.mishas.stuff.as.service;

import com.mishas.stuff.as.web.dto.SomeDto;
import org.springframework.scheduling.annotation.Async;

import java.util.concurrent.CompletableFuture;

public interface TimeWastingService {
    @Async
    CompletableFuture<SomeDto> wasteTime() throws InterruptedException;
}
