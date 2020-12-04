package app.meuplano.mpadmin;

import org.springdoc.core.SpringDocUtils;
import org.springdoc.core.converters.models.Pageable;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import app.meuplano.mpadmin.security.SpringSecurityAuditorAware;
import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.security.SecurityScheme;
import io.swagger.v3.oas.models.servers.Server;

@SpringBootApplication
@EnableJpaAuditing(auditorAwareRef = "auditorProvider")
public class MpAdminApplication {

	public static void main(String[] args) {
		SpringApplication.run(MpAdminApplication.class, args);
	}

	@Bean
	AuditorAware<String> auditorProvider() {
		return new SpringSecurityAuditorAware();
	}

	@Bean
	public OpenAPI springEventLogOpenAPI() {
		SpringDocUtils.getConfig().replaceWithClass(org.springframework.data.domain.Pageable.class, Pageable.class);
		return new OpenAPI().addServersItem(new Server().url("/"))
				.info(new Info().title("MEU PLANO.APP API").description("API do ADMIN do MEU PLANO.APP").version("v0.0.1")
						.license(new License().name("Apache	2.0").url("http://springdoc.org")))
				.components(new Components().addSecuritySchemes("TOKEN", new SecurityScheme().type(SecurityScheme.Type.HTTP)
						.scheme("bearer").bearerFormat("JWT").in(SecurityScheme.In.HEADER).name("Authorization")));
		// .addSecuritySchemes("basicScheme", new
		// SecurityScheme().type(SecurityScheme.Type.HTTP).scheme("basic")))

		// .addSecurityItem(new SecurityRequirement().addList("TOKEN",
		// Arrays.asList("read", "write")));

	}

}
