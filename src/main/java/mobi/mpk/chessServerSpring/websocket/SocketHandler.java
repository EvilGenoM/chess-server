package mobi.mpk.chessServerSpring.websocket;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import mobi.mpk.chessServerSpring.message.MessageRequest;
import mobi.mpk.chessServerSpring.websocket.manager.ManagerHandlerMessage;
import mobi.mpk.chessServerSpring.websocket.post.Post;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

@Component
public class SocketHandler extends TextWebSocketHandler {

    private static final Logger log = LoggerFactory.getLogger("WebSocket");

    private Post post;

    private ManagerHandlerMessage managerHandlerMessage;

    @Autowired
    public SocketHandler(Post post, ManagerHandlerMessage managerHandlerMessage) {

        this.post = post;

        this.managerHandlerMessage = managerHandlerMessage;

    }

    @Override
    public void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {

        log.info("send message");

        Gson gson = new GsonBuilder().create();
        MessageRequest messageRequest = gson.fromJson(message.getPayload(), MessageRequest.class);

        if(validate(messageRequest)) {

            post.setAddress(messageRequest.getUsername(), session);
            managerHandlerMessage.manage(messageRequest);

        }

    }

    private boolean validate(MessageRequest messageRequest) {

        if(messageRequest.getUsername() == null) {

            return false;

        }

        if(messageRequest.getType() == null) {

            return false;

        }

        return true;

    }

    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
        log.info("Connect new session");
    }

    @Override
    public void handleTransportError(WebSocketSession session, Throwable exception) throws Exception {
        log.info("Error" + exception);
    }

}
