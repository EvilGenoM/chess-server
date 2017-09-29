package mobi.mpk.chess.domain.figure;


import mobi.mpk.chess.domain.Color;

public class FactoryQueen extends FactoryFigure {
    @Override
    public Figure factoryMethod(Color color) {
        return new Queen(color);
    }
}
