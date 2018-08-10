package com.example.ulises.appserver.services;

import com.example.ulises.appserver.services.entities.App;
import com.example.ulises.appserver.services.repositories.AppRepository;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

@Service
public class AppServiceImpl implements AppService {
    @Autowired
    private AppRepository appRepository;


    @Override
    public void insert(final App app) {
        System.out.println(this.appRepository.insert(app).getId());
    }
}
