package mobi.mpk.chess.domain.figure;


import mobi.mpk.chess.domain.Color;

public class FactoryKing extends FactoryFigure{

    @Override
    public Figure factoryMethod(Color color) {
        return new King(color);
    }

}
