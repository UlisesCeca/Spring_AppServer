package com.example.ulises.appserver.rest.exceptionsmappers;

import com.example.ulises.appserver.constants.Constants;
import com.example.ulises.appserver.rest.dto.ErrorDTO;
import com.example.ulises.appserver.services.exceptions.AppAlreadyExistsException;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;

public class AppAlreadyExistsExceptionMapper implements ExceptionMapper<AppAlreadyExistsException> {
    @Override
    public Response toResponse(AppAlreadyExistsException e) {
        final ErrorDTO errorDTO = ErrorDTO.builder().
                message(Constants.RESPONSE_ERROR_APP_EXISTS).
                build();
        return Response.status(Response.Status.BAD_REQUEST).entity(errorDTO).build();
    }
}