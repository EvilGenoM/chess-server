package mobi.mpk.chess.domain.rules;

import mobi.mpk.chess.domain.Board;
import mobi.mpk.chess.domain.Stroke;

public interface InspectorRules {

    void checkMoveRules(Board board, Stroke stroke);

}
