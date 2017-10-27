package mobi.mpk.chessServerSpring.controller;

import mobi.mpk.chessServerSpring.User;
import mobi.mpk.chessServerSpring.domain.game.Game;
import mobi.mpk.chessServerSpring.model.Message;
import mobi.mpk.chessServerSpring.registry.GameRegistry;
import mobi.mpk.chessServerSpring.registry.UserRegistry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.messaging.simp.SimpMessageSendingOperations;
import org.springframework.messaging.simp.stomp.StompHeaderAccessor;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.messaging.SessionConnectedEvent;
import org.springframework.web.socket.messaging.SessionDisconnectEvent;

@Component
public class WebSocketEventListener {

    private static final Logger logger = LoggerFactory.getLogger(WebSocketEventListener.class);

    @Autowired
    private SimpMessageSendingOperations messagingTemplate;

    @Autowired
    private UserRegistry userRegistry;

    @Autowired
    private GameRegistry gameRegistry;

    @EventListener
    public void handleWebSocketConnectListener(SessionConnectedEvent event) {
        logger.info("Received a new web socket connection");
    }

    @EventListener
    public void handleWebSocketDisconnectListener(SessionDisconnectEvent event) {
        StompHeaderAccessor headerAccessor = StompHeaderAccessor.wrap(event.getMessage());

        String username = (String) headerAccessor.getSessionAttributes().get("username");
        if(username != null) {
            logger.info("User Disconnected : " + username);

            Message message = new Message();
            message.setType(Message.MessageType.LEAVE);
            message.setSender(username);

            removeGame(username);

            messagingTemplate.convertAndSend("/channel/public", message);
        }
    }

    private void removeGame(String username) {

        User user = (User) userRegistry.getElement(username);
        if(gameRegistry.checkKey(user)) {

            Game game = (Game) gameRegistry.getElement(user);

            Message messageDisconnect = new Message();
            messageDisconnect.setSender("Game");
            messageDisconnect.setContent(username + " disconnect");
            messageDisconnect.setType(Message.MessageType.GAME_DISCONNECT);

            gameRegistry.removeElement(game);

            messagingTemplate.convertAndSend("/channel/" + game.getName(), messageDisconnect);

        }

        userRegistry.removeElementKey(username);

    }

}
