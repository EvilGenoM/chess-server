package mobi.mpk.chessServerSpring.controller;

import mobi.mpk.chessServerSpring.User;
import mobi.mpk.chessServerSpring.domain.Color;
import mobi.mpk.chessServerSpring.domain.game.ClassicGame;
import mobi.mpk.chessServerSpring.domain.game.Game;
import mobi.mpk.chessServerSpring.model.Message;
import mobi.mpk.chessServerSpring.registry.GameRegistry;
import mobi.mpk.chessServerSpring.registry.UserRegistry;
import mobi.mpk.chessServerSpring.waitinglist.QueueWaitingList;
import mobi.mpk.chessServerSpring.waitinglist.WaitingList;
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

    @Autowired
    private QueueWaitingList waitingList;

    @MessageMapping("/server.{username}")
    public void sendMessage(@Payload Message message, @DestinationVariable("username") String username) {

        if (message.getType() == Message.MessageType.JOIN) {

            joinUser(message.getContent(), message);

        } else if (message.getType() == Message.MessageType.JOIN_REQUEST_YES) {

            beginGame(message, message.getContent());

        } else if (message.getType() == Message.MessageType.JOIN_REQUEST_NO) {

            String usernameEnemy = message.getContent();

            message.setType(Message.MessageType.JOIN_REQUEST_NO);

            message.setContent("Вы отказались!");
            simpMessagingTemplate.convertAndSend("/channel/" + message.getSender(), message);

            message.setContent(message.getSender() + " отказался от игры с вами!");
            simpMessagingTemplate.convertAndSend("/channel/" + usernameEnemy, message);

        } else {

            simpMessagingTemplate.convertAndSend("/channel/" + username, message);

        }

    }

    private void beginGame(Message message, String username) {

        message.setContent(message.getSender() + "to" + username);
        message.setType(Message.MessageType.GAME_START);

        simpMessagingTemplate.convertAndSend("/channel/" + message.getSender(), message);
        simpMessagingTemplate.convertAndSend("/channel/" + username, message);

        createGame(message.getSender(), username);

    }

    private void joinUser(String username, Message message) {

        if(userRegistry.checkKey(username)){

            message.setContent("Вам предложил поиграть игрок с ником " + message.getSender());
            simpMessagingTemplate.convertAndSend("/channel/"+username, message);

            message.setContent(username + " получил приглашение в игру!");
            message.setType(Message.MessageType.JOIN_SUCCESS);
            simpMessagingTemplate.convertAndSend("/channel/"+message.getSender(), message);

        } else {

            message.setContent("Игрок не найден");
            message.setType(Message.MessageType.JOIN_UNSUCCESS);
            simpMessagingTemplate.convertAndSend("/channel/"+message.getSender(), message);

        }

    }

    private void createGame(String username, String usernameEnemy) {
        User user1 = (User) userRegistry.getElement(username);
        User user2 = (User) userRegistry.getElement(usernameEnemy);

        Game game = new ClassicGame(user1, user2);
        game.setName(username+"to"+usernameEnemy);

        gameRegistry.addElement(user1, game);
        gameRegistry.addElement(user2, game);

        Message message = new Message();
        message.setSender("Game");
        message.setType(Message.MessageType.GAME_COLOR);

        Color color = game.getColor(user1);
        setColor(message, color);
        simpMessagingTemplate.convertAndSend("/channel/"+username, message);

        color = game.getColor(user2);
        setColor(message, color);
        simpMessagingTemplate.convertAndSend("/channel/"+usernameEnemy, message);

    }

    private void setColor(Message message, Color color) {

        if(Color.white == color) {
            message.setContent("white");
        } else {
            message.setContent("black");
        }

    }

    @MessageMapping("/waitlist.{username}")
    public void createRandomGame(@Payload Message message, @DestinationVariable("username") String username){

        User user = userRegistry.getElement(username);

        if(message.getType() == Message.MessageType.RANDOM_GAME) {

            if(waitingList.isEmpty()) {

                waitingList.addUser(user);

                message.setSender("Server");
                message.setContent("Ожидайте...");
                message.setType(Message.MessageType.RANDOM_GAME_WAIT);

                simpMessagingTemplate.convertAndSend("/channel/"+username, message);

            } else if(!waitingList.getUser().equals(user)) {

                User userEnemy = waitingList.pollUser();

                beginGame(message, userEnemy.getName());

            }

        }

    }

    @MessageMapping("/server.addUser")
    @SendTo("/channel/public")
    public Message addUser(@Payload Message message, SimpMessageHeaderAccessor headerAccessor){

        headerAccessor.getSessionAttributes().put("username", message.getSender());

        userRegistry.addElement(message.getSender(), new User(message.getSender()));

        return message;

    }

}
