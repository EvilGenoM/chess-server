package mobi.mpk.chess.handlermessage;

import mobi.mpk.chess.User;
import mobi.mpk.chess.domain.Player;
import mobi.mpk.chess.domain.ResultStroke;
import mobi.mpk.chess.domain.game.ClassicGame;
import mobi.mpk.chess.domain.game.Game;
import mobi.mpk.chess.message.Message;
import mobi.mpk.chess.message.Reply;
import mobi.mpk.chess.registry.UserRegistry;

public class GameHandlerMessage implements HandlerMessage {

    private Game game;
    private Player player1;
    private Player player2;

    public GameHandlerMessage(User user1, User user2){

        this.player1 = new Player(user1);
        this.player2 = new Player(user2);

        this.game = new ClassicGame(player1, player2);

    }

    @Override
    public Reply handleMessage(Message message) {

        User user = UserRegistry.getInstance().getElement(message.getName());
        Player player = getPlayer(user);

        String stroke = message.getText();
        ResultStroke resultStroke = game.doStroke(player, stroke);

        Reply reply = handleResultStroke(user, resultStroke, stroke);

        return reply;
    }

    private Player getPlayer(User user){

        User user1 = this.player1.getUser();
        if(user1.equals(user)){
            return this.player1;
        } else {
            return this.player2;
        }

    }

    private Reply handleResultStroke(User user, ResultStroke resultStroke, String stroke){

        Reply reply;

        if(resultStroke.isSuccess()){

            reply = new Reply(user.getName());
            reply.setText(stroke);
            reply.addUser(player1.getUser());
            reply.addUser(player2.getUser());

            return reply;

        } else {

            reply = new Reply("Server");
            reply.setText(resultStroke.getText());
            reply.addUser(user);

            return reply;
        }

    }

}
