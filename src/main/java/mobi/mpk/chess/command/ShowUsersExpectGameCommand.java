package mobi.mpk.chess.command;

import mobi.mpk.chess.User;
import mobi.mpk.chess.waitinglist.ClassicWaitingList;
import mobi.mpk.chess.waitinglist.WaitingList;

public class ShowUsersExpectGameCommand implements Command {

    @Override
    public String execute() {

        WaitingList waitingList = ClassicWaitingList.getInstance();

        String resultCommand = "List users want playing:";

        for(User user: waitingList.getListUser()){
            resultCommand += "\n" + user.getName();
        }


        return resultCommand;
    }

}
