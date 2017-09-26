package mobi.mpk.chess.message.factory;

import mobi.mpk.chess.message.ExitMessage;
import mobi.mpk.chess.message.JoinMessage;
import mobi.mpk.chess.message.Message;

public class JoinMessageFactory extends Factory {

    public JoinMessageFactory(String name) {
        super(name);
    }

    public Message methodFactory() {
        return new JoinMessage(getName());
    }

}
