package app.beatsmith.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableJpaRepositories("app.beatsmith.dao")
@EntityScan("app.beatsmith")
public class Server {

    /** Singleton Pattern **/
    private static final Server server = new Server();

    /** Über dieses Objekt wird der Server zur Laufzeit bedient **/
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
