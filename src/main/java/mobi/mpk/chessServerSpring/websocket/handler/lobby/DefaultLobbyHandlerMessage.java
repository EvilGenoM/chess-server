package mobi.mpk.chessServerSpring.websocket.handler.lobby;


import mobi.mpk.chessServerSpring.User;
import mobi.mpk.chessServerSpring.domain.Color;
import mobi.mpk.chessServerSpring.domain.game.ClassicGame;
import mobi.mpk.chessServerSpring.domain.game.Game;
import mobi.mpk.chessServerSpring.message.MessageResponse;
import mobi.mpk.chessServerSpring.registry.GameRegistry;
import mobi.mpk.chessServerSpring.registry.UserRegistry;
import mobi.mpk.chessServerSpring.waitinglist.QueueWaitingList;
import mobi.mpk.chessServerSpring.waitinglist.WaitingList;
import mobi.mpk.chessServerSpring.websocket.post.Post;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class DefaultLobbyHandlerMessage implements LobbyHandlerMessage {

    private Post post;

    private QueueWaitingList waitingList;
    private UserRegistry userRegistry;
    private GameRegistry gameRegistry;

    public DefaultLobbyHandlerMessage(Post post,
                                      QueueWaitingList waitingList,
                                      UserRegistry userRegistry,
                                      GameRegistry gameRegistry) {

        this.post = post;

        this.waitingList = waitingList;
        this.userRegistry = userRegistry;
        this.gameRegistry = gameRegistry;

    }

    @Override
    public void handleRandomGameFind(String username) {

        User user = (User) userRegistry.getElement(username);

        if(waitingList.isEmpty()) {

            waitingList.addUser(user);

            sendMessage(user, new MessageResponse(user.getName(),
                    null,
                    MessageResponse.ComandType.LOBBY,
                    MessageResponse.MessageType.RANDOM_GAME_WAIT));

        } else {

            User enemy = waitingList.getUser();
            Game game = new ClassicGame(user, enemy);

            gameRegistry.addElement(user, game);
            gameRegistry.addElement(enemy, game);

            sendMessage(user, new MessageResponse(user.getName(),
                    enemy.getName(),
                    MessageResponse.ComandType.LOBBY,
                    MessageResponse.MessageType.RANDOM_GAME_START));

            sendMessage(enemy, new MessageResponse(enemy.getName(),
                    user.getName(),
                    MessageResponse.ComandType.LOBBY,
                    MessageResponse.MessageType.RANDOM_GAME_START));

            sendColor(user, enemy);


        }

    }

    private void sendColor(User user, User enemy) {

        Game game = (Game) gameRegistry.getElement(user);

        Color color = game.getColor(user);

        if(color == Color.white) {

            sendMessage(user, new MessageResponse(user.getName(),
                    "white",
                    MessageResponse.ComandType.GAME,
                    MessageResponse.MessageType.GAME_COLOR));

            sendMessage(enemy, new MessageResponse(enemy.getName(),
                    "black",
                    MessageResponse.ComandType.GAME,
                    MessageResponse.MessageType.GAME_COLOR));

        } else {

            sendMessage(enemy, new MessageResponse(enemy.getName(),
                    "white",
                    MessageResponse.ComandType.GAME,
                    MessageResponse.MessageType.GAME_COLOR));

            sendMessage(user, new MessageResponse(user.getName(),
                    "black",
                    MessageResponse.ComandType.GAME,
                    MessageResponse.MessageType.GAME_COLOR));

        }

    }

    @Override
    public void handleRandomGameCancel(String username, String message) {

        waitingList.removeUser(username);

        User user = (User) userRegistry.getElement(username);

        sendMessage(user, new MessageResponse(user.getName(),
                null,
                MessageResponse.ComandType.LOBBY,
                MessageResponse.MessageType.RANDOM_GAME_CANCEL));

    }

    private void sendMessage(User user, MessageResponse response) {

        try {
            post.sendMessage(user.getName(), response);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
