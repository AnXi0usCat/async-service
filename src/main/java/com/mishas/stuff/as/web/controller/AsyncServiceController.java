package com.mishas.stuff.as.web.controller;

import com.mishas.stuff.as.service.RepositoryService;
import com.mishas.stuff.as.service.TimeWastingService;
import com.mishas.stuff.as.web.dto.SomeDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.ExecutionException;

@RestController
public class AsyncServiceController {

    private TimeWastingService timeWastingService;
    private RepositoryService repositoryService;

    @RequestMapping(value = "/api/v1/somethingAsync", method = RequestMethod.GET)
    @ResponseBody
    public SomeDto getSomeDto() {
        SomeDto result = null;
        try {
            result = timeWastingService.wasteTime().get();
            repositoryService.save(result);
        } catch (InterruptedException | ExecutionException ee) {
            // meow meow
        }
        return result;
    }

    @Autowired
    public void setTimeWastingService(TimeWastingService timeWastingService) {
        this.timeWastingService = timeWastingService;
    }
    @Autowired
    public void setRepositoryService(RepositoryService repositoryService) {
        this.repositoryService = repositoryService;
    }
}
