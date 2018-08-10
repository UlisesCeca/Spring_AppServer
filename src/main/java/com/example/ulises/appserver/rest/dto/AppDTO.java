package com.example.ulises.appserver.rest.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AppDTO {
    private String id;
    @NotNull(message = "name must not be null")
    private String name;
}
