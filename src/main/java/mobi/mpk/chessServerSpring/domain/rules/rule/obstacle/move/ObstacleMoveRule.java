package mobi.mpk.chessServerSpring.domain.rules.rule.obstacle.move;


import mobi.mpk.chessServerSpring.domain.Board;
import mobi.mpk.chessServerSpring.domain.Stroke;

public interface ObstacleMoveRule {

    boolean checkRule(Stroke stroke, Board board);

}
