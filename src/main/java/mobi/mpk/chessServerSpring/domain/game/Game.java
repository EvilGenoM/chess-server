package mobi.mpk.chessServerSpring.domain.game;


import mobi.mpk.chessServerSpring.User;
import mobi.mpk.chessServerSpring.domain.Board;
import mobi.mpk.chessServerSpring.domain.Color;
import mobi.mpk.chessServerSpring.domain.Player;
import mobi.mpk.chessServerSpring.domain.ResultStroke;
import mobi.mpk.chessServerSpring.domain.exception.CellCorrectException;
import mobi.mpk.chessServerSpring.domain.figure.Figure;
import mobi.mpk.chessServerSpring.domain.rules.InspectorRules;

import java.util.List;

public abstract class Game {

    private Player player1;
    private Player player2;

    private InspectorRules inspectorRules;

    private Board board;

    private String name;

    public Game(User user1, User user2, InspectorRules inspectorRules) {

        this.player1 = new Player(user1);
        this.player2 = new Player(user2);

        this.name = user1.getName()+"to"+user2.getName();

        this.player1.setColorFigures(Color.white);
        this.player2.setColorFigures(Color.black);

        this.inspectorRules = inspectorRules;

        try {

            this.board = new Board();

        } catch (CellCorrectException e) {
            e.printStackTrace();
        }

    }

    public abstract void initBoard();

    public abstract ResultStroke doStroke(User user, String stroke);

    public abstract List<Figure> getListFiguresOnBoard();

    protected Player getPlayer1() {
        return this.player1;
    }

    protected Player getPlayer2() {
        return this.player2;
    }

    protected Board getBoard() {
        return this.board;
    }

    protected InspectorRules getInspectorRules() {
        return this.inspectorRules;
    }

    public String getName() {
        return name;
    }


}
