package mobi.mpk.chess.net;

import mobi.mpk.chess.Config;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    int port = Config.PORT;

    public Server() {
        try {
            ServerSocket serverSocket = new ServerSocket(this.port);

            Logger log = LogManager.getLogger("server");
            log.info("Wait for the connection");

            while (true) {
                Socket socket = null;
                while (socket == null) {
                    socket = serverSocket.accept();
                }
                (new ClientThread(socket)).start();
            }

        } catch (IOException ex) {
            System.out.println(ex);
        }

    }


}
