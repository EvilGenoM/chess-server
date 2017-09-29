package mobi.mpk.chess.domain.figure;


import mobi.mpk.chess.domain.Color;

public class FactoryRook extends FactoryFigure{


    @Override
    public Figure factoryMethod(Color color) {
        return new Rook(color);
    }

}
