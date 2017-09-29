package mobi.mpk.chess.domain.game;

import mobi.mpk.chess.domain.Board;
import mobi.mpk.chess.domain.Color;
import mobi.mpk.chess.domain.Player;
import mobi.mpk.chess.domain.ResultStroke;
import mobi.mpk.chess.domain.exception.CellCorrectException;
import mobi.mpk.chess.domain.figure.Figure;
import mobi.mpk.chess.domain.rules.InspectorRules;

import java.util.List;

public abstract class Game {

    private Player player1;
    private Player player2;
    private InspectorRules inspectorRules;
    private Board board;

    public Game(Player player1, Player player2, InspectorRules inspectorRules) {

        this.player1 = player1;
        this.player2 = player2;

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

    public abstract ResultStroke doStroke(Player player, String stroke);

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

}
