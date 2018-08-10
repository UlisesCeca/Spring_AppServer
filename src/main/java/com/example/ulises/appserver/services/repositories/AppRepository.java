package com.example.ulises.appserver.services.repositories;

import com.example.ulises.appserver.services.entities.App;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AppRepository extends MongoRepository<App, String> {
    App findByName(String name);
}
