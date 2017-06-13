package com.actualize.mortgage;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
/**
 * This class initiates the current application 
 * @author sboragala
 *
 */
@SpringBootApplication
public class TriDentLeApplication {
	
	private static final Logger LOG = LogManager.getLogger(TriDentLeApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(TriDentLeApplication.class, args);
	}
}
