package com.ulises.appsserver.services.entities;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Apps")
@Data
public class App {
    @Id
    private String name;
    private String password;
}
