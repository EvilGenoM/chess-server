package mobi.mpk.chessServerSpring.websocket.handler.lobby;

import org.springframework.stereotype.Component;

@Component
public interface LobbyHandlerMessage {

    void handleRandomGameFind(String username);

    void handleRandomGameCancel(String username, String message);

}
