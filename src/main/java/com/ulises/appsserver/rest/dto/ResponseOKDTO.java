package com.ulises.appsserver.rest.dto;

import lombok.Builder;
import lombok.Data;

@Builder @Data
public class ResponseOKDTO {
    private final String message;
}
