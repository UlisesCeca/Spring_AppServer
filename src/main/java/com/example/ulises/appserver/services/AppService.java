package com.example.ulises.appserver.services;

import com.example.ulises.appserver.services.entities.App;

import java.util.List;

public interface AppService {
    void insert(final App app);
    List<App> getAll();
}
