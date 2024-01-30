package app.beatsmith;

import app.beatsmith.server.Server;

public class Beatsmith {
    public static void main(String[] args) {
        Server server = Server.getInstance();
        server.start();
    }
}
