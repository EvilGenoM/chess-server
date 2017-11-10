package mobi.mpk.chessServerSpring.websocket.handler.game;

import mobi.mpk.chessServerSpring.User;
import mobi.mpk.chessServerSpring.domain.ResultStroke;
import mobi.mpk.chessServerSpring.domain.game.Game;
import mobi.mpk.chessServerSpring.message.MessageResponse;
import mobi.mpk.chessServerSpring.registry.GameRegistry;
import mobi.mpk.chessServerSpring.registry.UserRegistry;
import mobi.mpk.chessServerSpring.websocket.post.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.List;

@Component
public class DefaultGameHandlerMessage implements GameHandlerMessage {

    private UserRegistry userRegistry;
    private GameRegistry gameRegistry;

    private Post post;

    @Autowired
    public DefaultGameHandlerMessage(UserRegistry userRegistry,
                                     GameRegistry gameRegistry,
                                     Post post) {

        this.userRegistry = userRegistry;
        this.gameRegistry = gameRegistry;

        this.post = post;

    }

    @Override
    public void handleGameStop(String username, String message) {
        // Stop Game
    }

    @Override
    public void handleMove(String username, String move) {

        User user = (User) userRegistry.getElement(username);
        Game game = (Game) gameRegistry.getElement(user);

        List<User> users = game.getUsers();

        ResultStroke result = game.doStroke(user, move);
        if(result.isSuccess()) {

            sendMove(user, move, users);

        }

    }

    private void sendMove(User userSender, String move, List<User> users) {

        for(User user : users) {

            if(user.equals(userSender)) {

                break;

            } else {

                sendMoveUser(user.getName(), new MessageResponse(userSender.getName(),
                        move,
                        MessageResponse.ComandType.GAME,
                        MessageResponse.MessageType.MOVE));

            }

        }

    }

    private void sendMoveUser(String username, MessageResponse messageResponse) {

        try {
            post.sendMessage(username, messageResponse);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
