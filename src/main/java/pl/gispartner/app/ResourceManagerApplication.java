package pl.gispartner.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class ResourceManagerApplication {

    public static void main(String[] args) {
        SpringApplication.run(ResourceManagerApplication.class, args);
    }

}
