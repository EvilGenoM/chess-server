package mobi.mpk.chess.domain.rules.rule.possiblemove;

import mobi.mpk.chess.domain.Color;
import mobi.mpk.chess.domain.Stroke;
import mobi.mpk.chess.domain.figure.Figure;

public class ClassicPossibleMoveRule implements PossibleMoveRule {


    @Override
    public boolean checkPossibleMove(Color color, Stroke stroke) {

        Figure figure = stroke.getFigure();
        if(figure.getColor() == color){
            return true;
        } else {
            return false;
        }

    }
}
