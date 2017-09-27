package mobi.mpk.chess.domain.rules.rule.way.figure;

import mobi.mpk.chess.domain.Board;
import mobi.mpk.chess.domain.Stroke;

public interface WayFigureRule {

    boolean wayFigure(Board board, Stroke stroke);

}
