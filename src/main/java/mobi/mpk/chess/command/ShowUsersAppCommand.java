package mobi.mpk.chess.command;

import mobi.mpk.chess.User;
import mobi.mpk.chess.registry.Registry;
import mobi.mpk.chess.registry.UserRegistry;

import java.util.List;

public class ShowUsersAppCommand implements Command {

    @Override
    public String execute() {

        Registry registry = UserRegistry.getInstance();
        List<User> users = registry.getListElement();
        String resultCommand = "List all users:";

        for (User user : users) {
            resultCommand += "\n" + user.getName();
        }

        return resultCommand;

    }

}
