package mobi.mpk.chess.domain.rules.rule.possiblemove;

import mobi.mpk.chess.domain.Color;
import mobi.mpk.chess.domain.Stroke;

public interface PossibleMoveRule {

    boolean checkPossibleMove(Color color, Stroke stroke);

}
