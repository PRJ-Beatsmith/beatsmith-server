package app.beatsmith.server.configuration;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.servers.Server;

@OpenAPIDefinition(
        info = @Info(
                title = "Beatsmith-Server",
                description = "Diese Dokumentation beschreibt die API (Application Programming Interface) des Beatsmith-Servers.",
                contact = @Contact(
                        name = "Luca Herrero Marcos",
                        url = "https://github.com/LucaHerrero",
                        email = "luca@herreromarcos.com"
                )),
        servers = @Server(url = "http://localhost:8080")
)
class OpenAPIConfiguration {
}