package app.beatsmith.hooks;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ShutdownHookConfiguration {

    public static final String SHUTDOWN_MESSAGE = ">> Die Anwendung wurde beendet. <<";
}