package com.example.ulises.appserver.rest.exceptionsmappers;

import com.example.ulises.appserver.rest.dto.ErrorDTO;
import com.example.ulises.appserver.services.exceptions.NoAppsException;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;

public class NoAppsExceptionMapper  implements ExceptionMapper<NoAppsException> {
    private final String NO_APPS = "No Apps found.";

    @Override
    public Response toResponse(NoAppsException e) {
        final ErrorDTO errorDTO = ErrorDTO.builder().
                message(NO_APPS).
                build();
        return Response.status(Response.Status.NOT_FOUND).entity(errorDTO).build();
    }
}