package mobi.mpk.chess.message;

import mobi.mpk.chess.message.exception.MessageErrorException;
import mobi.mpk.chess.message.factory.*;

import java.util.ArrayList;
import java.util.List;

public class ManagerMessage {

    private List<Factory> factoryMessage = new ArrayList<Factory>();

    public ManagerMessage(String name){

        factoryMessage.add(new ExitMessageFactory(name));
        factoryMessage.add(new ExpectMessageFactory(name));
        factoryMessage.add(new JoinMessageFactory(name));
        factoryMessage.add(new ShowUsersMessageFactory(name));
        factoryMessage.add(new ShowWaitingMessageFactory(name));
        factoryMessage.add(new StrokeMessageFactory(name));

    }

    public Message getMessage(String text) throws MessageErrorException {

        for(Factory factory: factoryMessage){

            Message message = factory.methodFactory();

            if(message.setText(text)){
                return message;
            }

        }

        throw new MessageErrorException();
    }

}
