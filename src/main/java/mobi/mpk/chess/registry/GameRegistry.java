package mobi.mpk.chess.registry;

import mobi.mpk.chess.User;
import mobi.mpk.chess.handlermessage.GameHandlerMessage;

import java.util.concurrent.ConcurrentHashMap;

public class GameRegistry<K, E> extends Registry<K, E> {

    private static GameRegistry<User, GameHandlerMessage> instance;

    private GameRegistry() {
        value = new ConcurrentHashMap<K, E>();
    }

    public static GameRegistry<User, GameHandlerMessage> getInstance() {
        if (instance == null) {
            synchronized (UserRegistry.class) {
                instance = new GameRegistry<User, GameHandlerMessage>();
            }
        }
        return instance;
    }


}
