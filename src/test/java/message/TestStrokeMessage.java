package message;

import mobi.mpk.chess.message.Message;
import mobi.mpk.chess.message.StrokeMessage;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestStrokeMessage {

    @Test
    public void testA1A2(){

        Message message = new StrokeMessage("Test");
        boolean expection = message.setText("a1 a2");

        assertEquals(expection, true);

    }

    @Test
    public void testA1H8(){

        Message message = new StrokeMessage("Test");
        boolean expection = message.setText("a1 h8");

        assertEquals(expection, true);

    }

    @Test
    public void testA8H8(){

        Message message = new StrokeMessage("Test");
        boolean expection = message.setText("a8 h8");

        assertEquals(expection, true);

    }

    @Test
    public void testI8H8(){

        Message message = new StrokeMessage("Test");
        boolean expection = message.setText("i8 h8");

        assertEquals(expection, false);

    }

    @Test
    public void testA9H8(){

        Message message = new StrokeMessage("Test");
        boolean expection = message.setText("a9 h8");

        assertEquals(expection, false);

    }

    @Test
    public void testA8G10(){

        Message message = new StrokeMessage("Test");
        boolean expection = message.setText("a8 g10");

        assertEquals(expection, false);

    }

    @Test
    public void testA8I8(){

        Message message = new StrokeMessage("Test");
        boolean expection = message.setText("a8 i8");

        assertEquals(expection, false);

    }

    @Test
    public void testRandomText(){

        Message message = new StrokeMessage("Test");
        boolean expection = message.setText("aasdasdasdad");

        assertEquals(expection, false);

    }

    @Test
    public void testAABB(){

        Message message = new StrokeMessage("Test");
        boolean expection = message.setText("aa bb");

        assertEquals(expection, false);

    }

    @Test
    public void test3Words(){

        Message message = new StrokeMessage("Test");
        boolean expection = message.setText("a1 b2 b3");

        assertEquals(expection, false);

    }

}
