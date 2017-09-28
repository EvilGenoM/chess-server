package mobi.mpk.chess.domain.figure.factory;


import mobi.mpk.chess.domain.Color;
import mobi.mpk.chess.domain.figure.Figure;
import mobi.mpk.chess.domain.figure.Queen;

public class FactoryQueen extends FactoryFigure {
    @Override
    public Figure factoryMethod(Color color) {
        return new Queen(color);
    }
}
