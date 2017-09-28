package mobi.mpk.chess.domain.rules.rule.stoke.figure;

import mobi.mpk.chess.domain.Cell;
import mobi.mpk.chess.domain.Stroke;

import java.util.LinkedList;
import java.util.List;

public class StrokeKingRule  implements StrokeFigureRule{

    @Override
    public boolean strokeFigureRule(Stroke stroke) {

        Cell from = stroke.getFrom();
        Cell to = stroke.getTo();

        if(from.getX()-to.getX() == 1){

            if(from.getY()-to.getY() == 1){
                return true; //down l
            } else if(from.getY()-to.getY() == -1){
                return true; //up l
            } else if(from.getY()-to.getY() == 0){
                return true; //left
            }

        } else if(from.getX()-to.getX() == -1) {

            if(from.getY()-to.getY() == 1){
                return true; //down r
            } else if(from.getY()-to.getY() == -1){
                return true; //up r
            } else if(from.getY()-to.getY() == 0){
                return true; //right
            }

        } else if(from.getX()-to.getX() == 0){

            if(from.getY()-to.getY() == 1){
                return true; //down
            } else if(from.getY()-to.getY() == -1){
                return true; //up
            }

        }

        return false;
    }

}
