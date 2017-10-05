package mobi.mpk.chessServerSpring.domain.figure;

import mobi.mpk.chessServerSpring.domain.Color;

public class FactoryQueen extends FactoryFigure {
    @Override
    public Figure factoryMethod(Color color) {
        return new Queen(color);
    }
}
