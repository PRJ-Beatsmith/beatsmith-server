package app.beatsmith.server.hooks;

import org.springframework.context.annotation.Configuration;

@Configuration
public class ShutdownHookConfiguration {

    public static final String SHUTDOWN_MESSAGE = ">> Die Anwendung wurde beendet. <<";

}