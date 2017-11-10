package mobi.mpk.chessServerSpring.websocket.handler.connection;

import mobi.mpk.chessServerSpring.User;
import mobi.mpk.chessServerSpring.registry.UserRegistry;
import mobi.mpk.chessServerSpring.websocket.post.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DefaultConnectionHandlerMessage implements ConnectionHandlerMessage {

    private UserRegistry userRegistry;
    private Post post;

    @Autowired
    public DefaultConnectionHandlerMessage(UserRegistry userRegistry, Post post) {

        this.userRegistry = userRegistry;
        this.post = post;

    }

    @Override
    public void handleConnection(String username) {

        User user = new User(username);

        userRegistry.addElement(username, user);

    }

    @Override
    public void handleDisconnection(String username, String message) {

        userRegistry.removeElement(username);
        post.removeAddress(username);

    }

}
