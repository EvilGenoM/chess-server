package mobi.mpk.chess.message.factory;

import mobi.mpk.chess.message.Message;

public abstract class Factory {

    private String name;

    public Factory(String name){

        this.name = name;

    }

    public abstract Message methodFactory();

    public String getName() {
        return name;
    }

}
