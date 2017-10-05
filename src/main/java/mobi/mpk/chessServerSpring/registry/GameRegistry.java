package mobi.mpk.chessServerSpring.registry;

import org.springframework.stereotype.Component;

import java.util.concurrent.ConcurrentHashMap;

@Component
public class GameRegistry<User, Game> extends Registry<User, Game> {

    public GameRegistry() {

        values = new ConcurrentHashMap<User, Game>();

    }


}
