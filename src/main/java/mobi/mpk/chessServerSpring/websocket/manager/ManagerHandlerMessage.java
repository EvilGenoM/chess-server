package mobi.mpk.chessServerSpring.websocket.manager;

import mobi.mpk.chessServerSpring.message.MessageRequest;
import org.springframework.stereotype.Component;

@Component
public interface ManagerHandlerMessage {

    void manage(MessageRequest messageRequest);

}
