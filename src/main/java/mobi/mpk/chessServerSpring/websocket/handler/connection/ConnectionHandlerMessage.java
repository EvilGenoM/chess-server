package mobi.mpk.chessServerSpring.websocket.handler.connection;

import org.springframework.stereotype.Component;

@Component
public interface ConnectionHandlerMessage {

    void handleConnection(String username);

    void handleDisconnection(String username, String message);

}
