package mobi.mpk.chessServerSpring.websocket.manager;

import mobi.mpk.chessServerSpring.message.MessageRequest;
import mobi.mpk.chessServerSpring.websocket.handler.connection.ConnectionHandlerMessage;
import mobi.mpk.chessServerSpring.websocket.handler.game.GameHandlerMessage;
import mobi.mpk.chessServerSpring.websocket.handler.lobby.LobbyHandlerMessage;
import org.junit.Before;
import org.junit.Test;

import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class TestManagerHandler {

    private ManagerHandlerMessage managerHandlerMessage;

    private ConnectionHandlerMessage connectionHandlerMessage;
    private GameHandlerMessage gameHandlerMessage;
    private LobbyHandlerMessage lobbyHandlerMessage;

    @Before
    public void before() {

        connectionHandlerMessage = mock(ConnectionHandlerMessage.class);
        gameHandlerMessage = mock(GameHandlerMessage.class);
        lobbyHandlerMessage = mock(LobbyHandlerMessage.class);

        managerHandlerMessage = new DefaultManagerHandlerMessage(connectionHandlerMessage,
                gameHandlerMessage,
                lobbyHandlerMessage);

    }

    @Test
    public void testConnection() {

        managerHandlerMessage.manage(createRequest(MessageRequest.MessageType.CONNECTION));

        verify(connectionHandlerMessage).handleConnection(anyString());

    }

    @Test
    public void testDisconnection() {

        managerHandlerMessage.manage(createRequest(MessageRequest.MessageType.DISCONNECTION));

        verify(connectionHandlerMessage).handleDisconnection(anyString(), anyString());

    }

    @Test
    public void testGameStart() {

        managerHandlerMessage.manage(createRequest(MessageRequest.MessageType.GAME_STOP));

        verify(gameHandlerMessage).handleGameStop(anyString(), anyString());

    }

    @Test
    public void testGameMove() {

        managerHandlerMessage.manage(createRequest(MessageRequest.MessageType.MOVE));

        verify(gameHandlerMessage).handleMove(anyString(), anyString());

    }

    @Test
    public void testRandomGameFind() {

        managerHandlerMessage.manage(createRequest(MessageRequest.MessageType.RANDOM_GAME_FIND));

        verify(lobbyHandlerMessage).handleRandomGameFind(anyString());

    }

    @Test
    public void testRandomGameCancel() {

        managerHandlerMessage.manage(createRequest(MessageRequest.MessageType.RANDOM_GAME_CANCEL));

        verify(lobbyHandlerMessage).handleRandomGameCancel(anyString(), anyString());

    }

    private MessageRequest createRequest(MessageRequest.MessageType type) {

        return new MessageRequest("Tester",
                null,
                type);

    }


}
