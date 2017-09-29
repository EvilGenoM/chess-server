package mobi.mpk.chess.command;

import mobi.mpk.chess.User;
import mobi.mpk.chess.registry.UserRegistry;
import mobi.mpk.chess.waitinglist.ClassicWaitingList;

public class ExpectGameCommand implements Command {

    private User user;

    public ExpectGameCommand(String userName) {

        User user = UserRegistry.getInstance().getElement(userName);
        this.user = user;

    }

    @Override
    public String execute() {

        if (user == null) {
            return "Error";
        } else {
            ClassicWaitingList.getInstance().addUser(this.user);
        }

        return "Wait for the connection";

    }

}