package com.mishas.stuff.as.service.impl;

import com.mishas.stuff.as.persistence.dao.SomeRepository;
import com.mishas.stuff.as.persistence.model.SomeModel;
import com.mishas.stuff.as.service.RepositoryService;
import com.mishas.stuff.as.web.dto.SomeDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RepositoryServiceImpl implements RepositoryService {

    private SomeRepository repository;

    @Override
    public void save(SomeDto someDto) {
        repository.save(new SomeModel(someDto));
    }


    @Autowired
    public void setRepository(SomeRepository repository) {
        this.repository = repository;
    }
}
