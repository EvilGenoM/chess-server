package mobi.mpk.chessServerSpring.domain.figure;

import mobi.mpk.chessServerSpring.domain.Color;

public class FactoryPawn extends FactoryFigure {

    @Override
    public Figure factoryMethod(Color color) {
        return new Pawn(color);
    }

}
