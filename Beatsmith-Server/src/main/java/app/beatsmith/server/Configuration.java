package app.beatsmith.server;

import app.beatsmith.servicer.MavenReaderService;
import app.beatsmith.servicer.UserService;
import app.beatsmith.servicer.UserServiceImpl;
import org.codehaus.plexus.util.xml.pull.XmlPullParserException;
import org.springframework.context.annotation.Bean;

import java.io.IOException;

@org.springframework.context.annotation.Configuration
public class Configuration {
    @Bean
    public MavenReaderService getMavenReaderService() {
        try {
            return new MavenReaderService();
        } catch (XmlPullParserException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Bean
    public UserService userService() {
        return new UserServiceImpl();
    }

}
