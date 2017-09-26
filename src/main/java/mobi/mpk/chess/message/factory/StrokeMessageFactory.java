package mobi.mpk.chess.message.factory;

import mobi.mpk.chess.message.ExitMessage;
import mobi.mpk.chess.message.Message;
import mobi.mpk.chess.message.StrokeMessage;

public class StrokeMessageFactory extends Factory {

    public StrokeMessageFactory(String name) {
        super(name);
    }

    public Message methodFactory() {
        return new StrokeMessage(getName());
    }

}
