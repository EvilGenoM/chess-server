package mobi.mpk.chess.command;

import mobi.mpk.chess.User;
import mobi.mpk.chess.handlermessage.GameHandlerMessage;
import mobi.mpk.chess.registry.GameRegistry;
import mobi.mpk.chess.registry.UserRegistry;
import mobi.mpk.chess.waitinglist.ClassicWaitingList;
import mobi.mpk.chess.waitinglist.WaitingList;

public class JoinPlayerCommand implements Command {

    private User user1;
    private User user2;

    public JoinPlayerCommand(String user1Name, String user2Name) {

        User user = UserRegistry.getInstance().getElement(user1Name);
        this.user1 = user;

        user = UserRegistry.getInstance().getElement(user2Name);
        this.user2 = user;

    }

    @Override
    public String execute() {

        if (this.user1 == null || this.user2 == null) {
            return "Error";
        } else if(this.user1.equals(this.user2)){
            return "Error: You entered your name";
        } else if(ClassicWaitingList.getInstance().checkUser(user2)){

            GameHandlerMessage controllerGame = new GameHandlerMessage(user1, user2);
            GameRegistry.getInstance().addElement(user1, controllerGame);
            GameRegistry.getInstance().addElement(user2, controllerGame);
            return "Connect";

        } else {
            return "Error: User did not wait game";
        }

    }

}
