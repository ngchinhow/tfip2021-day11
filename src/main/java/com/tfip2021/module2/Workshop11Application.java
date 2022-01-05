package com.tfip2021.module2;

import java.util.Collections;

// import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.DefaultApplicationArguments;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@SpringBootApplication
public class Workshop11Application {
	private static final Logger logger = LoggerFactory.getLogger(Workshop11Application.class);
	private static final String DEFAULT_PORT = "3000";

	public static void main(String[] args) {
		logger.info("Workshop 11");
		SpringApplication app = new SpringApplication(Workshop11Application.class);
		String port = System.getProperty("PORT", DEFAULT_PORT);
		ApplicationArguments cliOpts = new DefaultApplicationArguments(args);
		if (cliOpts.containsOption("port")) {
			port = cliOpts.getOptionValues("port").get(0);
		}
		logger.debug(port);
		app.setDefaultProperties(
			Collections.singletonMap("server.port", port)
		);
		app.run(args);
	}

}
