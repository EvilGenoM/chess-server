package mobi.mpk.chess.domain.rules.rule.obstacle.move;

import mobi.mpk.chess.domain.Board;
import mobi.mpk.chess.domain.Cell;
import mobi.mpk.chess.domain.Stroke;
import mobi.mpk.chess.domain.figure.Figure;
import mobi.mpk.chess.domain.figure.Knight;

public class ObstacleMoveKnightRule implements ObstacleMoveRule {

    @Override
    public boolean checkRule(Stroke stroke, Board board) {

        Cell to = stroke.getTo();
        to = board.getCell(to);

        Figure figure = stroke.getFigure();

        if (!figure.equals(new Knight())) {
            return false;
        }

        if (to.getFigure() == null) {
            return true;
        } else if (to.getFigure().getColor() != figure.getColor()) {
            return true;
        } else {
            return false;
        }

    }

}
