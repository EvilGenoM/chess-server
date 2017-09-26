package mobi.mpk.chess.message.factory;

import mobi.mpk.chess.message.Message;
import mobi.mpk.chess.message.ShowUsersMessage;

public class ShowUsersMessageFactory extends Factory {

    public ShowUsersMessageFactory(String name) {
        super(name);
    }

    public Message methodFactory() {
        return new ShowUsersMessage(getName());
    }

}
