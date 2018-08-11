package com.ulises.appsserver.services.repositories;

import com.ulises.appsserver.services.entities.App;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AppRepository extends MongoRepository<App, String> {
    App findByName(String name);
}
