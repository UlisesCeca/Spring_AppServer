package com.example.ulises.appserver.rest.dto;

import lombok.Builder;
import lombok.Data;

@Builder @Data
public class OkResponseDTO {
    private String message;
}
