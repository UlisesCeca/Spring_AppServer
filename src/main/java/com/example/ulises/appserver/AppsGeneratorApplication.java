package com.example.ulises.appserver;

import com.example.ulises.appserver.rest.endpoints.AppEndpoint;
import org.glassfish.jersey.server.ResourceConfig;
import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class AppsGeneratorApplication {

	public static void main(String[] args) {
		SpringApplication.run(AppsGeneratorApplication.class, args);
	}


	@Bean
	public ResourceConfig jerseyConfig() {
		final ResourceConfig resourceConfig = new ResourceConfig();
		resourceConfig.register(AppEndpoint.class);
		return resourceConfig;
	}

	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}
}
