package app.beatsmith.server;

import app.beatsmith.servicer.MavenReaderService;
import org.springframework.context.annotation.Bean;

@org.springframework.context.annotation.Configuration
public class Configuration {
    @Bean
    public MavenReaderService getMavenReaderService() {
        try {
            return new MavenReaderService();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
