package com.rhadamez.mezicashapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

import com.rhadamez.mezicashapi.config.property.MezicashApiProperty;

@SpringBootApplication
@EnableConfigurationProperties(MezicashApiProperty.class)
public class MezicashApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(MezicashApiApplication.class, args);
	}

}
