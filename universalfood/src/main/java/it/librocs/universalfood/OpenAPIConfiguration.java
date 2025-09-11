package it.librocs.universalfood;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.info.BuildProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.servers.Server;

@Configuration
public class OpenAPIConfiguration {

    @Autowired
    BuildProperties buildProperties;

    @Bean
    public OpenAPI defineOpenApi() {
        Server server = new Server();
        server.setUrl("");
        server.setDescription("API per il UniversalFood");

        Contact myContact = new Contact();
        myContact.setName("Santiago Kumarashi");
        myContact.setEmail("santiago.kumarashi@🌏🍽️.com");

        Info information = new Info()
            .title("API per la gestione dei menu di UniversalFood")
            .version(buildProperties.getVersion())
            .description("Questa API espone degli endpoint per gestire i menu di UniversalFood.")
            .contact(myContact);
        return new OpenAPI().info(information);
    }

}
