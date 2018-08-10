package com.example.ulises.appserver.services;

import com.example.ulises.appserver.services.entities.App;
import com.example.ulises.appserver.services.exceptions.AppAlreadyExistsException;
import com.example.ulises.appserver.services.exceptions.NoAppsException;
import com.example.ulises.appserver.services.repositories.AppRepository;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Service
public class AppServiceImpl implements AppService {
    @Autowired
    private AppRepository appRepository;


    @Override
    public void insert(final App app) {
        if(this.appRepository.findByName(app.getName()) == null)
            this.appRepository.insert(app);
        else
            throw new AppAlreadyExistsException();
    }

    @Override
    public List<App> getAll() {
        if(this.appRepository.count() == 0)
            throw new NoAppsException();
        else
            return this.appRepository.findAll();
    }


}
