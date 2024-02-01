package app.beatsmith.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
public class Server {

    private static final Server server = new Server();
    private ConfigurableApplicationContext ctx;

    /**
     * Verendung nicht erlaubt, da Singleton Pattern angewandt wurde.
     */
    public Server() {
    }

    public static Server getInstance() {
        return server;
    }

    public void start() {
        String[] springArgs = {};
        this.ctx = SpringApplication.run(Server.class, springArgs);
    }

    public void stop() {
        ctx.stop();
        this.ctx = null;
    }
}
