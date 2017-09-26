package mobi.mpk.chess.message.factory;

import mobi.mpk.chess.message.ExitMessage;
import mobi.mpk.chess.message.Message;

public class ExpectMessageFactory extends Factory {

    public ExpectMessageFactory(String name) {
        super(name);
    }

    public Message methodFactory() {
        return new ExitMessage(getName());
    }

}
