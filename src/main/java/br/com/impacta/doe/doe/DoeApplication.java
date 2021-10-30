package br.com.impacta.doe.doe;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class DoeApplication {

	public static void main(String[] args) {
		SpringApplication.run(DoeApplication.class, args);
	}

}
