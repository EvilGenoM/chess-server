package mobi.mpk.chessServerSpring.websocket.manager;

import mobi.mpk.chessServerSpring.message.MessageRequest;
import mobi.mpk.chessServerSpring.websocket.handler.connection.ConnectionHandlerMessage;
import mobi.mpk.chessServerSpring.websocket.handler.game.GameHandlerMessage;
import mobi.mpk.chessServerSpring.websocket.handler.lobby.LobbyHandlerMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DefaultManagerHandlerMessage implements ManagerHandlerMessage {

    private ConnectionHandlerMessage connectionHandlerMessage;
    private GameHandlerMessage gameHandlerMessage;
    private LobbyHandlerMessage lobbyHandlerMessage;

    @Autowired
    public DefaultManagerHandlerMessage(ConnectionHandlerMessage connectionHandlerMessage,
                                        GameHandlerMessage gameHandlerMessage,
                                        LobbyHandlerMessage lobbyHandlerMessage) {

        this.connectionHandlerMessage = connectionHandlerMessage;
        this.gameHandlerMessage = gameHandlerMessage;
        this.lobbyHandlerMessage = lobbyHandlerMessage;

    }

    @Override
    public void manage(MessageRequest messageRequest) {

        String username = messageRequest.getUsername();
        String text = messageRequest.getText();

        switch (messageRequest.getType()) {

            case CONNECTION:
                connectionHandlerMessage.handleConnection(username);
                break;
            case DISCONNECTION:
                connectionHandlerMessage.handleDisconnection(username, text);
                break;
            case GAME_STOP:
                gameHandlerMessage.handleGameStop(username, text);
                break;
            case MOVE:
                gameHandlerMessage.handleMove(username, text);
                break;
            case RANDOM_GAME_FIND:
                lobbyHandlerMessage.handleRandomGameFind(username);
                break;
            case RANDOM_GAME_CANCEL:
                lobbyHandlerMessage.handleRandomGameCancel(username, text);
                break;

        }

    }

}
