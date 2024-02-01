package app.beatsmith;

import app.beatsmith.server.Server;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class Beatsmith {
    protected static final Logger LOG = LogManager.getLogger();

    public static void main(String[] args) {
        LOG.error("TEST");
        Server server = Server.getInstance();
        server.start();
    }
}
