package mobi.mpk.chess.domain.rules;

import mobi.mpk.chess.domain.Board;
import mobi.mpk.chess.domain.Stroke;
import mobi.mpk.chess.domain.rules.rule.order.figure.OrderFigureRule;
import mobi.mpk.chess.domain.rules.rule.stoke.figure.StrokeFigureRule;
import mobi.mpk.chess.domain.rules.rule.way.figure.WayFigureRule;

import java.util.ArrayList;
import java.util.List;

public class ClassicInspectorRules implements InspectorRules{

    List<StrokeFigureRule> strokeFigureRules;
    List<WayFigureRule> wayFigureRules;

    public ClassicInspectorRules(){

        strokeFigureRules = new ArrayList<>();

//        strokeFigureRules.add();...

    }

    @Override
    public void checkMoveRules(Board board, Stroke stroke) {

    }

}
