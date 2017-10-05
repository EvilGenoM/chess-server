package mobi.mpk.chessServerSpring.controller;

import mobi.mpk.chessServerSpring.User;
import mobi.mpk.chessServerSpring.domain.game.ClassicGame;
import mobi.mpk.chessServerSpring.domain.game.Game;
import mobi.mpk.chessServerSpring.model.Message;
import mobi.mpk.chessServerSpring.registry.GameRegistry;
import mobi.mpk.chessServerSpring.registry.UserRegistry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

@Controller
public class LobbyController {

    @Autowired
    private SimpMessagingTemplate simpMessagingTemplate;

    @Autowired
    private GameRegistry gameRegistry;

    @Autowired
    private UserRegistry<String, User> userRegistry;

    @MessageMapping("/server.{username}")
    public void sendMessage(@Payload Message message, @DestinationVariable("username") String username){

        if(message.getType() == Message.MessageType.JOIN_REQUEST && message.getContent().equals("Yes")){

            message.setContent("/game/"+username+"to"+message.getSender());
            createGame(username, message.getSender());

            simpMessagingTemplate.convertAndSend("/channel/"+message.getSender(), message);

        }

        simpMessagingTemplate.convertAndSend("/channel/"+username, message);

    }

    private void createGame(String username, String sender) {
        User user1 = (User) userRegistry.getElement(username);
        User user2 = (User) userRegistry.getElement(sender);

        Game game = new ClassicGame(user1, user2);

        gameRegistry.addElement(user1, game);
        gameRegistry.addElement(user2, game);

    }

    @MessageMapping("/server.addUser")
    @SendTo("/lobby/public")
    public Message addUser(@Payload Message message, SimpMessageHeaderAccessor headerAccessor){

        headerAccessor.getSessionAttributes().put("username", message.getSender());

        userRegistry.addElement(message.getSender(), new User(message.getSender()));

        return message;

    }

}
