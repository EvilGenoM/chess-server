package mobi.mpk.chess.command;

import mobi.mpk.chess.User;
import mobi.mpk.chess.handlermessage.GameHandlerMessage;
import mobi.mpk.chess.registry.GameRegistry;
import mobi.mpk.chess.registry.UserRegistry;

public class JoinPlayerCommand implements Command {

    private User user1;
    private User user2;

    public JoinPlayerCommand(String user1Name, String user2Name){

        User user = UserRegistry.getInstance().getElement(user1Name);
        this.user1 = user;

        user = UserRegistry.getInstance().getElement(user2Name);
        this.user2 = user;

    }

    @Override
    public String execute() {

        if(this.user1 == null || this.user2 == null){
            return "Error";
        } else {
            GameHandlerMessage controllerGame = new GameHandlerMessage(user1, user2);
            GameRegistry.getInstance().addElement(user1, controllerGame);
            GameRegistry.getInstance().addElement(user2, controllerGame);
            return "Connect";
        }

    }

}
