package app.meuplano.usertest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class UsertestApplication {

	public static void main(String[] args) {
		SpringApplication.run(UsertestApplication.class, args);
	}

}
