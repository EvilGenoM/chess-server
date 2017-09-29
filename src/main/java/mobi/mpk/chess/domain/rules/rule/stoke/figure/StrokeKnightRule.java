package mobi.mpk.chess.domain.rules.rule.stoke.figure;

import mobi.mpk.chess.domain.Cell;
import mobi.mpk.chess.domain.Stroke;
import mobi.mpk.chess.domain.figure.King;
import mobi.mpk.chess.domain.figure.Knight;

import java.util.LinkedList;
import java.util.List;

public class StrokeKnightRule implements StrokeFigureRule {

    @Override
    public boolean checkRule(Stroke stroke) {

        Cell from = stroke.getFrom();
        Cell to = stroke.getTo();

        if (!stroke.getFigure().equals(new Knight())) {
            return false;
        }

        if (from.getX() - to.getX() == 1) {

            if (from.getY() - to.getY() == 2) {
                return true;
            } else if (from.getY() - to.getY() == -2) {
                return true;
            }

        } else if (from.getX() - to.getX() == -1) {

            if (from.getY() - to.getY() == 2) {
                return true;
            } else if (from.getY() - to.getY() == -2) {
                return true;
            }

        } else if (from.getY() - to.getY() == 1) {

            if (from.getX() - to.getX() == 2) {
                return true;
            } else if (from.getX() - to.getX() == -2) {
                return true;
            }

        } else if (from.getY() - to.getY() == -1) {

            if (from.getX() - to.getX() == 2) {
                return true;
            } else if (from.getX() - to.getX() == -2) {
                return true;
            }

        }

        return false;
    }

}
