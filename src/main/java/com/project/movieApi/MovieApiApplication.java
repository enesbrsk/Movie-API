package com.project.movieApi;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@SpringBootApplication
public class MovieApiApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(MovieApiApplication.class, args);
	}


	@Override
	public void run(String... args) throws Exception {

	}

	@Bean
	public OpenAPI customOpenAPI() {
		return new OpenAPI()
				.info(new Info()
						.title("Movie API")
						.version("1.0")
						.description("This is an api which provides movie information with actors")
						.license(new License().name("Folksdev Movie API Licence")));
	}

}