package mobi.mpk.chess.domain.rules.rule.end.game;

import mobi.mpk.chess.domain.Board;
import mobi.mpk.chess.domain.Color;

public interface EndGameRule {

    boolean checkRule(Board board);

    Color getColorWinner();

}
