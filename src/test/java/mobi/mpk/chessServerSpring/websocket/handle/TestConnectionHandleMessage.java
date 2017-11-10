package mobi.mpk.chessServerSpring.websocket.handle;

import mobi.mpk.chessServerSpring.User;
import mobi.mpk.chessServerSpring.registry.UserRegistry;
import mobi.mpk.chessServerSpring.websocket.handler.connection.ConnectionHandlerMessage;
import mobi.mpk.chessServerSpring.websocket.handler.connection.DefaultConnectionHandlerMessage;
import mobi.mpk.chessServerSpring.websocket.post.DefaultPost;
import mobi.mpk.chessServerSpring.websocket.post.Post;
import org.junit.Before;
import org.junit.Test;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.WebSocketSessionDecorator;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;

public class TestConnectionHandleMessage {

    private ConnectionHandlerMessage handler;

    private String username = "Tester";

    private Post post;
    private UserRegistry userRegistry;

    @Before
    public void before() {

        userRegistry = new UserRegistry();

        post = new DefaultPost(userRegistry);

        handler = new DefaultConnectionHandlerMessage(userRegistry, post);

    }

    @Test
    public void testConnection() {

        handler.handleConnection(username);

        User user = (User) userRegistry.getElement(username);

        assertEquals(username,user.getName());

    }

    @Test
    public void testDisconnection() {

        handler.handleDisconnection(username, null);

        User user = (User) userRegistry.getElement(username);

        assertEquals(user, null);

    }

}
