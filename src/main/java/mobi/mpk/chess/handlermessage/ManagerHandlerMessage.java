package mobi.mpk.chess.handlermessage;

import mobi.mpk.chess.User;
import mobi.mpk.chess.registry.GameRegistry;

public class ManagerHandlerMessage {

    public HandlerMessage getHandlerMessage(User user){

        if(GameRegistry.getInstance().checkKey(user)){
            return GameRegistry.getInstance().getElement(user);
        } else {
            return new LobbyHandlerMessage();
        }

    }

}
