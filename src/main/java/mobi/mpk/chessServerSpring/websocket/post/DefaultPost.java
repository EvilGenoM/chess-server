package mobi.mpk.chessServerSpring.websocket.post;

import com.google.gson.Gson;
import mobi.mpk.chessServerSpring.User;
import mobi.mpk.chessServerSpring.message.MessageResponse;
import mobi.mpk.chessServerSpring.registry.UserRegistry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;

import javax.websocket.Session;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Component
public class DefaultPost implements Post {

    private Map<User, WebSocketSession> addresses;

    private UserRegistry userRegistry;

    @Autowired
    public DefaultPost(UserRegistry userRegistry) {

        this.addresses = new ConcurrentHashMap<>();

        this.userRegistry = userRegistry;

    }

    @Override
    public boolean setAddress(String username, WebSocketSession session) {

        User user = (User) userRegistry.getElement(username);

        if(user != null) {

            addresses.put(user, session);
            return true;

        } else {

            return false;

        }

    }

    @Override
    public boolean removeAddress(String username) {

        User user = (User) userRegistry.getElement(username);

        if(user != null) {

            addresses.remove(user);
            return true;

        }

        return false;

    }

    @Override
    public void sendMessage(String username, MessageResponse response) throws IOException {

        User user = (User) userRegistry.getElement(username);
        WebSocketSession session = addresses.get(user);

        String jsonMessage = new Gson().toJson(response);
        session.sendMessage(new TextMessage(jsonMessage));

    }

}
