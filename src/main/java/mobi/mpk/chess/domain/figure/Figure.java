package mobi.mpk.chess.domain.figure;

import mobi.mpk.chess.domain.Color;

public abstract class Figure {

    private Color color;

    public Figure(Color color){
        this.color = color;
    }

    public Color getColor() {
        return color;
    }

}
