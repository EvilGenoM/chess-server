package mobi.mpk.chess.domain.rules.rule.end.game;

import mobi.mpk.chess.domain.Board;
import mobi.mpk.chess.domain.Color;
import mobi.mpk.chess.domain.figure.King;

public class ClassicEndGameRule implements EndGameRule {

    private Color colorWinner;

    @Override
    public boolean checkRule(Board board) {

        if (!board.existFigure(new King(Color.white))) {

            colorWinner = Color.black;
            return true;

        } else if (!board.existFigure(new King(Color.black))) {

            colorWinner = Color.white;
            return true;

        } else {
            return false;
        }

    }

    @Override
    public Color getColorWinner() {
        return colorWinner;
    }
}
