package com.example.springs.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeIn;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.security.SecurityScheme;
import io.swagger.v3.oas.annotations.servers.Server;

@OpenAPIDefinition(
        info = @Info(
                contact = @Contact(
                        name = "santosh", email = "santos.timil@gmail.com"
                ),
                description = "open-api documentation for spring services",
                title = "Open API Documentation- santosh"
                , version = "1.0.0"
                , license = @License(
                name = "License - named "),
                termsOfService = "Terms of Service"),
        servers = {
                @Server(
                        description = "LocalServer", url = "http://localhost:8080")
                , @Server(
                description = "Production", url = "http://190.120.1.0:8080")
        }
        , security = {@SecurityRequirement(
        name = "basicauth")
}
)
@SecurityScheme(description = "Security",
        name = "basicauth",
        scheme = "Basic"
        , type = SecuritySchemeType.HTTP,
        bearerFormat = "Basic",
        in = SecuritySchemeIn.HEADER
)

public class SwaggerOpenApiConfig {
}
