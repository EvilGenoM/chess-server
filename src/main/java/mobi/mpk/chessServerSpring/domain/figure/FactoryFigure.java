package mobi.mpk.chessServerSpring.domain.figure;


import mobi.mpk.chessServerSpring.domain.Color;

public abstract class FactoryFigure {

    public abstract Figure factoryMethod(Color color);

}
