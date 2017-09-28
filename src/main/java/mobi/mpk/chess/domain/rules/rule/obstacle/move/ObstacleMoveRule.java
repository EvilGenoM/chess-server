package mobi.mpk.chess.domain.rules.rule.obstacle.move;

import mobi.mpk.chess.domain.Board;
import mobi.mpk.chess.domain.Stroke;

public interface ObstacleMoveRule {

    boolean checkRule(Stroke stroke, Board board);

}
