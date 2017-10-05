package mobi.mpk.chessServerSpring.domain.figure;

import mobi.mpk.chessServerSpring.domain.Color;

public class FactoryRook extends FactoryFigure {


    @Override
    public Figure factoryMethod(Color color) {
        return new Rook(color);
    }

}
