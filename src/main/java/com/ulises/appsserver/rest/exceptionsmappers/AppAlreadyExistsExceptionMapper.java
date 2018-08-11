package com.ulises.appsserver.rest.exceptionsmappers;

import com.ulises.appsserver.constants.Constants;
import com.ulises.appsserver.rest.dto.ErrorDTO;
import com.ulises.appsserver.services.exceptions.AppAlreadyExistsException;

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