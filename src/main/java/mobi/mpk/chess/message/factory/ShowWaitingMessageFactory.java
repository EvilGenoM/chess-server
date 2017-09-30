package mobi.mpk.chess.message.factory;

import mobi.mpk.chess.message.Message;
import mobi.mpk.chess.message.UsersMessage;

public class ShowWaitingMessageFactory extends Factory {

    public ShowWaitingMessageFactory(String name) {
        super(name);
    }

    public Message methodFactory() {
        return new UsersMessage(getName());
    }

}
