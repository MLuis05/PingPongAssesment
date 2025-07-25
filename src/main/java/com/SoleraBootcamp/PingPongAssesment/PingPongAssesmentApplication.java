package com.SoleraBootcamp.PingPongAssesment;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan(basePackages = "com.SoleraBootcamp.PingPongAssesment")
@EnableJpaRepositories(basePackages = "com.SoleraBootcamp.PingPongAssesment.Repository")
public class PingPongAssesmentApplication {

	public static void main(String[] args) {
		SpringApplication.run(PingPongAssesmentApplication.class, args);
	}

}
