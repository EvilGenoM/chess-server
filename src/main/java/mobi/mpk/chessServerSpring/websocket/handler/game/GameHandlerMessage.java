package mobi.mpk.chessServerSpring.websocket.handler.game;

import org.springframework.stereotype.Component;

@Component
public interface GameHandlerMessage {

    void handleGameStop(String username, String message);

    void handleMove(String username, String move);

}
