package mobi.mpk.chess.domain.rules.rule.stoke.figure;

import mobi.mpk.chess.domain.Cell;
import mobi.mpk.chess.domain.Stroke;

import java.util.LinkedList;
import java.util.List;

public class StrokeRookRule implements StrokeFigureRule {

    @Override
    public boolean strokeFigureRule(Stroke stroke) {

        Cell from = stroke.getFrom();
        Cell to = stroke.getTo();

        boolean isStroke = true;

        if(from.getX()-to.getX()>0 && from.getY() == to.getY()){ // left

            return isStroke;

        } else if(from.getX()-to.getX()<0 && from.getY() == to.getY()){ // right

            return isStroke;

        } else if(from.getY()-to.getY()>0 && from.getX() == to.getX()){ // down

            return isStroke;

        } else if(from.getY()-to.getY()<0 && from.getX() == to.getX()){ // up

            return isStroke;

        }

        isStroke = false;
        return isStroke;

    }

}
