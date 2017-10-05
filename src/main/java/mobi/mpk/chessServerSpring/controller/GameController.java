package mobi.mpk.chessServerSpring.controller;

import mobi.mpk.chessServerSpring.model.Message;
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
    private UserRegistry userRegistry;

    @MessageMapping("/game.{username}")
    public void sendPrivateMessage(@Payload Message message, @DestinationVariable("username") String username){

        User user = userRegistry.getUser(username);
        Game game = gameRegistry.getGame(user);

        String result = game.doStroke(message.getContent());

        Message messageResult = new Message();
        message.setSender("Server");
        message.setContent(result);
        message.setType(Message.MessageType.RESULT_STROKE);

        simpMessagingTemplate.convertAndSend("/channel/"+username, messageResult);

        if(result.equals("Success")){
            simpMessagingTemplate.convertAndSend("/game/"+game.getName(), message);
        }

    }

}
