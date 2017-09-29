package mobi.mpk.chess.domain.figure;


import mobi.mpk.chess.domain.Color;

public class FactoryKnight extends FactoryFigure{
    @Override
    public Figure factoryMethod(Color color) {
        return new Knight(color);
    }
}
