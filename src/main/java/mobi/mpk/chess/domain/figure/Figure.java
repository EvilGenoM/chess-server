package mobi.mpk.chess.domain.figure;

import mobi.mpk.chess.domain.Color;

public abstract class Figure {

    private Color color;

    public Figure(){
        this(Color.white);
    }

    public Figure(Color color){
        this.color = color;
    }

    public Color getColor() {
        return color;
    }

    @Override
    public boolean equals(Object o){

        if(this == null || o == null){
            return false;
        }

        if(this.getClass().getSimpleName().equals(o.getClass().getSimpleName())){

            return true;

        } else {
            return false;
        }

    }

}
