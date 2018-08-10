package com.example.ulises.appserver.rest.endpoints;

import com.example.ulises.appserver.rest.dto.AppDTO;
import com.example.ulises.appserver.rest.dto.OkResponseDTO;
import com.example.ulises.appserver.services.entities.App;
import com.example.ulises.appserver.services.AppService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
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
    public Response insert(@Valid @NotNull(message = "body must not be null") final AppDTO appDTO) {
        this.appService.insert(this.modelMapper.map(appDTO, App.class));
        return Response.ok(OkResponseDTO.builder().message("App created successfully").build()).build();
    }

    @GET
    @Path("/getAll")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAll() {
        List<AppDTO> appDTOList = this.appService.getAll()
                .stream()
                .map(app -> this.modelMapper.map(app, AppDTO.class))
                .collect(Collectors.toList());
        return Response.ok(appDTOList).build();
    }

}
