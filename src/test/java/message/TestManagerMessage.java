package message;

import mobi.mpk.chess.message.manager.ManagerMessage;
import mobi.mpk.chess.message.Message;
import mobi.mpk.chess.message.exception.MessageErrorException;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;

public class TestManagerMessage {

    @Test
    public void testExit(){

        ManagerMessage manager = new ManagerMessage("Test");
        try {
            Message message = manager.getMessage("exit");

            assertEquals(message.getText(), "exit");
        } catch (MessageErrorException e) {
            e.printStackTrace();
        }

    }

    @Test
    public void testExpect(){

        ManagerMessage manager = new ManagerMessage("Test");
        try {
            Message message = manager.getMessage("expect");

            assertEquals(message.getText(), "expect");
        } catch (MessageErrorException e) {
            e.printStackTrace();
        }

    }

    @Test
    public void testJoin(){

        ManagerMessage manager = new ManagerMessage("Test");
        try {
            Message message = manager.getMessage("join");

            assertEquals(message.getText(), "join");
        } catch (MessageErrorException e) {
            e.printStackTrace();
        }

    }

    @Test
    public void testShowUsers(){

        ManagerMessage manager = new ManagerMessage("Test");
        try {
            Message message = manager.getMessage("show users");

            assertEquals(message.getText(), "show users");
        } catch (MessageErrorException e) {
            e.printStackTrace();
        }

    }

    @Test
    public void testShowWaiting(){

        ManagerMessage manager = new ManagerMessage("Test");
        try {
            Message message = manager.getMessage("show waiting");

            assertEquals(message.getText(), "show waiting");
        } catch (MessageErrorException e) {
            e.printStackTrace();
        }

    }

    @Test
    public void testStroke(){

        ManagerMessage manager = new ManagerMessage("Test");
        try {
            Message message = manager.getMessage("a1 b1");

            assertEquals(message.getText(), "a1 b1");
        } catch (MessageErrorException e) {
            e.printStackTrace();
        }

    }


    @Test(expected = MessageErrorException.class)
    public void testException() throws MessageErrorException {
        ManagerMessage managerMessage = new ManagerMessage("Test");
        managerMessage.getMessage("a1 a2 a3");
    }

    @Test(expected = MessageErrorException.class)
    public void testExceptionMockito() throws MessageErrorException {

        ManagerMessage manager = mock(ManagerMessage.class);
        doThrow(new MessageErrorException()).when(manager).getMessage("a1 a2 a3");
        manager.getMessage("a1 a2 a3");

    }
}
