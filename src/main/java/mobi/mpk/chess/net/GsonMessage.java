package mobi.mpk.chess.net;

public class GsonMessage {

    String name;
    String text;

    public GsonMessage(String name, String text){

        this.name = name;
        this.text = text;

    }

    @Override
    public boolean equals(Object o){

        GsonMessage gsonMessage = (GsonMessage) o;

        if(this == o){
            return true;
        } else if(gsonMessage.text.equals(this.text) && gsonMessage.name.equals(this.name)){
            return true;
        } else{
            return false;
        }

    }


}
