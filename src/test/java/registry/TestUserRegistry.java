package registry;

import mobi.mpk.chess.User;
import mobi.mpk.chess.registry.Registry;
import mobi.mpk.chess.registry.UserRegistry;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class TestUserRegistry {

    @Test
    public void testCreate(){

        Registry registry = UserRegistry.getInstance();

        assertEquals(registry, UserRegistry.getInstance());

    }

    @Test
    public void testAddGet(){

        Registry registry = UserRegistry.getInstance();
        registry.clear();

        User user = new User("TestUserRegistry");
        registry.addElement("TestUserRegistry", user);

        assertEquals(registry.getElement("TestUserRegistry"), user);

    }

    @Test
    public void testGetList(){

        Registry registry = UserRegistry.getInstance();
        registry.clear();

        User user = new User("TestUserRegistry");
        registry.addElement("TestUserRegistry", user);

        List<User> list = new ArrayList<User>();
        list.add(user);

        assertEquals(registry.getListElement(), list);

    }

    @Test
    public void testDelete(){

        Registry registry = UserRegistry.getInstance();
        registry.clear();

        User user = new User("TestUserRegistry");
        registry.addElement("TestUserRegistry", user);
        registry.removeElementKey("TestUserRegistry");

        List<User> list = new ArrayList<User>();

        assertEquals(registry.getListElement(), list);

    }

    @Test
    public void testCheckElement(){

        Registry registry = UserRegistry.getInstance();
        registry.clear();

        User user = new User("TestUserRegistry");
        registry.addElement("TestUserRegistry", user);

        assertEquals(registry.checkElement(user), true);

    }

    @Test
    public void testCheckElementFalse(){

        Registry registry = UserRegistry.getInstance();
        registry.clear();

        User user = new User("TestUserRegistry");

        assertEquals(registry.checkElement(user), false);

    }

}
