package mobi.mpk.chess.domain.rules;

import mobi.mpk.chess.domain.Board;
import mobi.mpk.chess.domain.Color;
import mobi.mpk.chess.domain.Stroke;
import mobi.mpk.chess.domain.figure.Figure;

import java.util.List;

public interface InspectorRules {

    void checkMoveRules(Board board, Stroke stroke, Color colorPlayer) throws Exception;

    List<Figure> getOrderFigure(Color color);

}
