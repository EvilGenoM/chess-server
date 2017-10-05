package mobi.mpk.chessServerSpring.controller;

import mobi.mpk.chessServerSpring.model.Message;
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
    private UserRegistry userRegistry;

    @MessageMapping("/server.{username}")
    public void sendPrivateMessage(@Payload Message message, @DestinationVariable("username") String username){

        if(message.getType() == Message.MessageType.JOIN_REQUEST && message.getContent().equals("Yes")){

            message.setContent("/game/"+username+"to"+message.getSender());
            Game game = createGame(username, message.getSender());
            fillGameRegistry(username, message.getSender());

            simpMessagingTemplate.convertAndSend("/channel/"+message.getSender(), message);

        }

        simpMessagingTemplate.convertAndSend("/channel/"+username, message);

    }

    @MessageMapping("/server.addUser")
    @SendTo("/lobby/public")
    public Message addUser(@Payload Message message, SimpMessageHeaderAccessor headerAccessor){

        headerAccessor.getSessionAttributes().put("username", message.getSender());

        userRegistry.addUser(message.getSender(), new User(message.getSender()));

        return message;

    }

}
