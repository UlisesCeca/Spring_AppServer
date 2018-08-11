package com.ulises.appsserver.services;

import com.ulises.appsserver.services.entities.App;
import com.ulises.appsserver.services.exceptions.AppAlreadyExistsException;
import com.ulises.appsserver.services.exceptions.NoAppsException;
import com.ulises.appsserver.services.repositories.AppRepository;
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
