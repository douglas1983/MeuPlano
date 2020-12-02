package app.meuplano.mpeurekaserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class MpEurekaServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(MpEurekaServerApplication.class, args);
	}

}
