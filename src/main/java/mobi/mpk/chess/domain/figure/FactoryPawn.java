package mobi.mpk.chess.domain.figure;


import mobi.mpk.chess.domain.Color;

public class FactoryPawn extends FactoryFigure{

    @Override
    public Figure factoryMethod(Color color) {
        return new Pawn(color);
    }

}
