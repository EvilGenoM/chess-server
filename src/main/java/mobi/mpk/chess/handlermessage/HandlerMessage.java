package mobi.mpk.chess.handlermessage;

import mobi.mpk.chess.message.Message;
import mobi.mpk.chess.message.ReplyMessage;

public interface HandlerMessage {

    ReplyMessage handleMessage(Message message);

}
