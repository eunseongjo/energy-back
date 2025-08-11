package com.iya.energy;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.iya.energy")
public class energyApplication {

	public static void main(String[] args) {
		SpringApplication.run(energyApplication.class, args);
	}

}
