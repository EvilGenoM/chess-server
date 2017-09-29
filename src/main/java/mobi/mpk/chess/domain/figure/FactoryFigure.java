package mobi.mpk.chess.domain.figure;


import mobi.mpk.chess.domain.Color;

public abstract class FactoryFigure {

    public abstract Figure factoryMethod(Color color);

}
