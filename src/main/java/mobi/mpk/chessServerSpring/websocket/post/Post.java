package mobi.mpk.chessServerSpring.websocket.post;

import mobi.mpk.chessServerSpring.message.MessageResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.WebSocketSession;

import java.io.IOException;

@Component
public interface Post {

    boolean setAddress(String username, WebSocketSession session);

    boolean removeAddress(String username);

    void sendMessage(String username, MessageResponse response) throws IOException;
}
