package mobi.mpk.chessServerSpring.controller;

import mobi.mpk.chessServerSpring.User;
import mobi.mpk.chessServerSpring.domain.game.Game;
import mobi.mpk.chessServerSpring.model.Message;
import mobi.mpk.chessServerSpring.registry.GameRegistry;
import mobi.mpk.chessServerSpring.registry.UserRegistry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

@Controller
public class GameController {

    @Autowired
    private SimpMessagingTemplate simpMessagingTemplate;

    @Autowired
    private GameRegistry gameRegistry;

    @Autowired
    private UserRegistry<String, User> userRegistry;

    @MessageMapping("/game.{username}")
    public void sendPrivateMessage(@Payload Message message, @DestinationVariable("username") String username){

        User user = (User) userRegistry.getElement(username);
        Game game = (Game) gameRegistry.getElement(user);

        String result = "";
//        result = game.doStroke(user, message.getContent());

        Message messageResult = new Message();
        message.setSender("Server");
        message.setContent(result);

        simpMessagingTemplate.convertAndSend("/channel/"+username, messageResult);

        if(result.equals("Success")){
            simpMessagingTemplate.convertAndSend("/game/"+game.getName(), message);
        }

    }

}
