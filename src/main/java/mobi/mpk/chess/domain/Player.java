package mobi.mpk.chess.domain;

import mobi.mpk.chess.User;
import mobi.mpk.chess.domain.rules.InspectorRules;

public class Player {

    private User user;
    private Color colorFigures;

    public Player(User user){
        this.user = user;
    }

    public User getUser(){
        return this.user;
    }

    public boolean move(Stroke stroke, Board board, InspectorRules inspectorRules){

        inspectorRules.checkMoveRules(board, stroke);

        return true;

    }

    public Color getColorFigures() {
        return colorFigures;
    }

    public void setColorFigures(Color colorFigures) {
        this.colorFigures = colorFigures;
    }

}
