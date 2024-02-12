package app.beatsmith.server;

import app.beatsmith.servicer.MavenReaderService;
import org.codehaus.plexus.util.xml.pull.XmlPullParserException;
import org.springframework.context.annotation.Bean;

import java.io.IOException;

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
