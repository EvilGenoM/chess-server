package mobi.mpk.chessServerSpring.websocket.post;

import mobi.mpk.chessServerSpring.User;
import mobi.mpk.chessServerSpring.registry.UserRegistry;
import org.junit.Before;
import org.junit.Test;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;

import java.io.IOException;

import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class TestPost {

    private String username = "Tester";

    private Post post;
    private UserRegistry userRegistry;

    @Before
    public void before() {

        userRegistry = new UserRegistry();

        userRegistry.addElement(username, new User(username));

        post = new DefaultPost(userRegistry);

    }

    @Test
    public void testSetAddress() {

        WebSocketSession webSocketSession = mock(WebSocketSession.class);

        boolean isSuccess = post.setAddress(username, webSocketSession);

        assertEquals(isSuccess, true);

    }

    @Test
    public void testRemoveAddress() {

        boolean isSuccess = post.removeAddress(username);

        assertEquals(isSuccess, true);

    }

    @Test
    public void testSendMessage() throws IOException {

        WebSocketSession webSocketSession = mock(WebSocketSession.class);

        post.setAddress(username, webSocketSession);

        post.sendMessage(username, null);

        verify(webSocketSession).sendMessage(new TextMessage(anyString()));

    }

}
