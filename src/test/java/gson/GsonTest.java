package gson;

import com.google.gson.Gson;
import mobi.mpk.chess.net.GsonMessage;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class GsonTest {

    @Test
    public void voidCreate(){

        Gson gson = new Gson();
        GsonMessage gsonMessage = new GsonMessage("TestGson", "Test");
        String gsonString = gson.toJson(gsonMessage);

        GsonMessage gsonMessage2 = gson.fromJson(gsonString, GsonMessage.class);

        assertEquals(gsonMessage, gsonMessage2);

    }

}
