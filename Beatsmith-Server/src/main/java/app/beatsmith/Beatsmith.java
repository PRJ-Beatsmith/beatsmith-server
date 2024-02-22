package app.beatsmith;

import app.beatsmith.server.SpringServer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;


public class Beatsmith {

    private static final Logger LOG = LoggerFactory.getLogger(Beatsmith.class);

    public static void main(String[] args) {
        LOG.info("Beatsmith: Starting server");

        final SpringServer springServer = SpringServer.getInstance();
        springServer.start();

        LOG.info("Beatsmith: Started server");

        serverRestartLoop(springServer);
    }

    private static void serverRestartLoop(SpringServer springServer) {
        LOG.info("Beatsmith: Waiting for Server to die");
        boolean whileTrue = true;
        while (whileTrue) {
            try {
                if (!springServer.isServerRunning()) {
                    LOG.info("Beatsmith:  Server died. :(");
                    LOG.info("Beatsmith: Restarting application. BYE.");
                    restartApplication();
                }
            } catch (IOException ioException) {
                whileTrue = false;
                LOG.error("Beatsmith: Server finally died. Server will not automatically Restart.", ioException);
            } catch (Exception e) {
                LOG.error("Beatsmith: ", e);
            }
            try {
                Thread.sleep(5000); // 5 Sekunden Pause
            } catch (InterruptedException e) {
                LOG.error("Beatsmith: ", e);
            }
        }
    }

    private static void restartApplication() throws IOException, URISyntaxException {
        final String javaBin = System.getProperty("java.home") + File.separator + "bin" + File.separator + "java";
        final File currentJar = new File(Beatsmith.class.getProtectionDomain().getCodeSource().getLocation().toURI());

        /* is it a jar file? */
        if (!currentJar.getName().endsWith(".jar")) {
            return;
        }

        /* Build command: java -jar application.jar */
        final ArrayList<String> command = new ArrayList<String>();
        command.add(javaBin);
        command.add("-jar");
        command.add(currentJar.getPath());

        final ProcessBuilder builder = new ProcessBuilder(command);
        builder.start();
        System.exit(0);
    }
}
