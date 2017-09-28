package mobi.mpk.chess.domain.rules.rule.stoke.figure;

import mobi.mpk.chess.domain.Cell;
import mobi.mpk.chess.domain.Color;
import mobi.mpk.chess.domain.Stroke;
import mobi.mpk.chess.domain.figure.Figure;

public class StrokePawnRule implements StrokeFigureRule {

    @Override
    public boolean strokeFigureRule(Stroke stroke) {

        Cell from = stroke.getFrom();
        Cell to = stroke.getTo();
        Figure figure = stroke.getFigure();

        if (figure.getColor() == Color.white) {
            return isStrokeWhitePawn(from, to);
        } else {
            return isStrokeBlackPawn(from, to);
        }

    }

    private boolean isStrokeWhitePawn(Cell from, Cell to) {

        boolean isStroke = true;

        if (to.getY() - from.getY() == 1) { // 1 cell

            return isStroke;

        } else if (to.getY() - from.getY() == 2 && from.getY() == 2) { // 2 cell

            return isStroke;

        } else if (Math.abs(to.getY() - from.getY()) == Math.abs(to.getX() - from.getX())) { //attack
            if (to.getX() - from.getX() == 1 && to.getY() - from.getY() == 1) { //right

                return isStroke;

            } else if (to.getX() - from.getX() == -1 && to.getY() - from.getY() == 1) { //left

                return isStroke;

            }
        }

        isStroke = false;
        return isStroke;

    }

    private boolean isStrokeBlackPawn(Cell from, Cell to) {

        boolean isStroke = true;

        if (to.getY() - from.getY() == -1) { // 1 cell

            return isStroke;

        } else if (to.getY() - from.getY() == -2 && from.getY() == 7) { // 2 cell

            return isStroke;

        } else if (Math.abs(to.getY() - from.getY()) == Math.abs(to.getX() - from.getX())) { //attack

            if (to.getX() - from.getX() == 1 && to.getY() - from.getY() == -1) { //right

                return isStroke;

            } else if (to.getX() - from.getX() == -1 && to.getY() - from.getY() == -1) { //left

                    return isStroke;

            }
        }

        isStroke = false;
        return isStroke;
    }

}
