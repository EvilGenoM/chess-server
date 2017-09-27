package mobi.mpk.chess.domain.rules.rule.order.figure;

import mobi.mpk.chess.domain.Color;
import mobi.mpk.chess.domain.figure.Figure;

import java.util.List;

public interface OrderFigureRule {

    List<Figure> orderFigureRule(Color color);

}
