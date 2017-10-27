package mobi.mpk.chessServerSpring.registry;

import org.springframework.stereotype.Component;

import java.util.concurrent.ConcurrentHashMap;

@Component
public class UserRegistry<String, User> extends Registry<String, User> {

    private int anon;

    public UserRegistry() {

        values = new ConcurrentHashMap<String, User>();
        anon = 0;

    }

    public java.lang.String addAnonymous(java.lang.String name) {

        if(anon != 0) {

             name = name + anon;

        }

        values.put((String) name, (User) new mobi.mpk.chessServerSpring.User(name));

        anon++;

        return name;

    }

}
