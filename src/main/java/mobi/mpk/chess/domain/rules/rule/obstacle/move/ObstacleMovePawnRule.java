package mobi.mpk.chess.domain.rules.rule.obstacle.move;

import mobi.mpk.chess.domain.Board;
import mobi.mpk.chess.domain.Cell;
import mobi.mpk.chess.domain.Stroke;
import mobi.mpk.chess.domain.figure.Figure;
import mobi.mpk.chess.domain.figure.Pawn;

public class ObstacleMovePawnRule implements ObstacleMoveRule {

    @Override
    public boolean checkRule(Stroke stroke, Board board) {

        boolean isCheck = true;

        Cell from = stroke.getFrom();
        Cell to = stroke.getTo();
        Figure figure = stroke.getFigure();

        if(!figure.equals(new Pawn())){
            isCheck = false;
            return isCheck;
        }

        return true;

    }

}
