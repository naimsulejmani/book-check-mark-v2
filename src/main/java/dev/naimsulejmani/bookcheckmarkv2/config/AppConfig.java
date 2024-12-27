package dev.naimsulejmani.bookcheckmarkv2.config;

import dev.naimsulejmani.bookcheckmarkv2.repositories.DbInitializer;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public ApplicationRunner initializer(DbInitializer dbInitializer) {
        return args -> dbInitializer.run();
    }
}
