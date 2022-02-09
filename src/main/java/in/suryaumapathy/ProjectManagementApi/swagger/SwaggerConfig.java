package in.suryaumapathy.ProjectManagementApi.swagger;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.security.SecurityScheme;

@Configuration
public class SwaggerConfig {

        @Bean
        public OpenAPI customOpenAPI() {
                return new OpenAPI()
                                .components(new Components().addSecuritySchemes("basicScheme",
                                                new SecurityScheme().type(SecurityScheme.Type.HTTP).scheme("basic")))
                                .info(new Info().title("Project Management System").version("1.0.0")
                                                .description("Maintain Projects with multiple repositories")
                                                .termsOfService("http://swagger.io/terms/")
                                                .license(new License().name("Apache 2.0").url("http://springdoc.org")));
        }

}
