package mobi.mpk.chessServerSpring.domain.rules;

import mobi.mpk.chessServerSpring.domain.Board;
import mobi.mpk.chessServerSpring.domain.Color;
import mobi.mpk.chessServerSpring.domain.Stroke;
import mobi.mpk.chessServerSpring.domain.figure.Figure;

import java.util.List;

public interface InspectorRules {

    void checkMoveRules(Board board, Stroke stroke, Color colorPlayer) throws Exception;

    List<Figure> getOrderFigure(Color color);

}
