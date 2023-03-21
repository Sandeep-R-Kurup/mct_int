package com.SandeepRKurup.mct_int;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
@EntityScan("com.SandeepRkurup.mct_int.model.order")
public class MctIntApplication {

	public static void main(String[] args) {
		SpringApplication.run(MctIntApplication.class, args);
	}

}
