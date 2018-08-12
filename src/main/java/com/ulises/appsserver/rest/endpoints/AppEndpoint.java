package com.ulises.appsserver.rest.endpoints;

import com.ulises.appsserver.constants.Constants;
import com.ulises.appsserver.rest.dto.AppDTO;
import com.ulises.appsserver.rest.dto.ResponseOKDTO;
import com.ulises.appsserver.services.entities.App;
import com.ulises.appsserver.services.AppService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;
import java.util.stream.Collectors;

@Component
@Path("/app")
public class AppEndpoint {
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private AppService appService;

    @POST
    @Path("/new")
    @Produces(MediaType.APPLICATION_JSON)
    public Response insert(@Valid @NotNull(message =  Constants.REQUEST_ERROR_NULL_BODY) final AppDTO appDTO) {
        this.appService.insert(this.modelMapper.map(appDTO, App.class));
        return Response.ok(ResponseOKDTO.builder().message(Constants.RESPONSE_OK_APP_CREATED).build()).build();
    }

    @GET
    @Path("/getAll")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAll(@HeaderParam("Authorization") final String userAgent) {

        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        System.out.println(userAgent.equalsIgnoreCase("a"));
        List<AppDTO> appDTOList = this.appService.getAll()
                .stream()
                .map(app -> this.modelMapper.map(app, AppDTO.class))
                .collect(Collectors.toList());
        return Response.ok(appDTOList).build();
    }

}
