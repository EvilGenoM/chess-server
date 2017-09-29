package mobi.mpk.chess.net;

import com.google.gson.Gson;
import mobi.mpk.chess.User;
import mobi.mpk.chess.message.Reply;
import mobi.mpk.chess.registry.UserRegistry;

import java.io.DataOutputStream;
import java.io.IOException;

public class Sender {

    public void send(Reply reply) throws IOException {

        UserRegistry registry = UserRegistry.getInstance();
        for(User user : reply.getUser()) {
            DataOutputStream out = registry.getAdress(user);

            Gson gson = new Gson();
            String gsonStr = gson.toJson(reply);

            out.writeUTF(gsonStr);
        }

    }

}
