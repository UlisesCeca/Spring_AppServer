package com.ulises.appsserver.services;

import com.ulises.appsserver.services.entities.App;

import java.util.List;

public interface AppService {
    void insert(final App app);
    List<App> getAll();
}
