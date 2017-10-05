package mobi.mpk.chessServerSpring.domain.rules.rule.order.figure;

import mobi.mpk.chessServerSpring.domain.Color;
import mobi.mpk.chessServerSpring.domain.figure.Figure;

import java.util.List;

public interface OrderFigureRule {

    List<Figure> orderFigure(Color color);

}
