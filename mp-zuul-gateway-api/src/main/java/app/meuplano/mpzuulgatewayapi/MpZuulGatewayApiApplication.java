package app.meuplano.mpzuulgatewayapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@EnableEurekaClient
@EnableZuulProxy
@SpringBootApplication
public class MpZuulGatewayApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(MpZuulGatewayApiApplication.class, args);
	}

}
