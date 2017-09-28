package mobi.mpk.chess.domain.figure.factory;


import mobi.mpk.chess.domain.Color;
import mobi.mpk.chess.domain.figure.Figure;
import mobi.mpk.chess.domain.figure.Rook;

public class FactoryRook extends FactoryFigure {


    @Override
    public Figure factoryMethod(Color color) {
        return new Rook(color);
    }

}
