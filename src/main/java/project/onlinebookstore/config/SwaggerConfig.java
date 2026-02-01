package project.onlinebookstore.config;


import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;

import io.swagger.v3.oas.annotations.security.SecurityScheme;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@SecurityScheme(
        name = "bearerAuth",
        type = SecuritySchemeType.HTTP,
        scheme = "bearer",
        bearerFormat = "JWT"
)
public class SwaggerConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Online Book Store API")
                        .version("1.0.0")
                        .description("Online Book Store REST API documentation")
                        .contact(new Contact()
                                .name("OnlineBookStore Team")
                                .email("support@onlinebookstore.com")
                        )
                );
    }
}