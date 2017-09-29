package mobi.mpk.chess.domain.figure;


import mobi.mpk.chess.domain.Color;

public class FactoryBishop extends FactoryFigure {

    @Override
    public Figure factoryMethod(Color color) {
        return new Bishop(color);
    }

}
