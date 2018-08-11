package com.ulises.appsserver;

import com.ulises.appsserver.rest.endpoints.AppEndpoint;
import com.ulises.appsserver.rest.exceptionsmappers.AppAlreadyExistsExceptionMapper;
import com.ulises.appsserver.rest.exceptionsmappers.InternalServerErrorMapper;
import com.ulises.appsserver.rest.exceptionsmappers.NoAppsExceptionMapper;
import com.ulises.appsserver.rest.exceptionsmappers.NotFoundMapper;
import org.glassfish.jersey.server.ResourceConfig;
import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class AppServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(AppServerApplication.class, args);
	}


	@Bean
	public ResourceConfig jerseyConfig() {
		final ResourceConfig resourceConfig = new ResourceConfig();
		resourceConfig.register(AppEndpoint.class);
		resourceConfig.register(AppAlreadyExistsExceptionMapper.class);
		resourceConfig.register(NoAppsExceptionMapper.class);
		resourceConfig.register(NotFoundMapper.class);
		resourceConfig.register(InternalServerErrorMapper.class);
		return resourceConfig;
	}

	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}
}
