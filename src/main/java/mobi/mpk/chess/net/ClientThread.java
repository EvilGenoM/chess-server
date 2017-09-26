package mobi.mpk.chess.net;


import com.google.gson.Gson;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class ClientThread extends Thread {

    private Socket socket;

    public ClientThread(Socket socket){

        this.socket = socket;

    }

    public void run(){

        try{
            DataInputStream in = new DataInputStream(this.socket.getInputStream());
            DataOutputStream out = new DataOutputStream(this.socket.getOutputStream());

            Gson gson = new Gson();

            while(true){

            }

        } catch (IOException ex){
            System.out.println(ex);
        }

    }


}
