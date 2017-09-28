package mobi.mpk.chess.domain.rules.rule.obstacle.move;

import mobi.mpk.chess.domain.Board;
import mobi.mpk.chess.domain.Cell;
import mobi.mpk.chess.domain.Stroke;
import mobi.mpk.chess.domain.figure.Figure;
import mobi.mpk.chess.domain.figure.Knight;
import mobi.mpk.chess.domain.figure.Pawn;

import java.util.LinkedList;
import java.util.List;

public class ObstacleMoveLineRule implements ObstacleMoveRule {

    @Override
    public boolean checkRule(Stroke stroke, Board board) {

        boolean isCheck = false;

        Cell from = stroke.getFrom();
        Cell to = stroke.getTo();
        Figure figure = stroke.getFigure();

        if(figure.equals(new Pawn()) || figure.equals(new Knight())){
            return isCheck;
        }

        if(from.getY() - to.getY() == 0){
            return checkVerticalWayFigure(from, to, figure, board);
        } else if(from.getX() - to.getX() == 0){
            return checkHorizontWayFigure(from, to, figure, board);
        } else {
            return isCheck;
        }

    }

    private boolean checkHorizontWayFigure(Cell from, Cell to, Figure figure, Board board){

        char fromX = from.getX();
        int fromY = from.getY();

        char toX = to.getX();

        int changeX = (toX-fromX)/Math.abs(toX-fromX);

        while(fromX != toX){

            fromX += changeX;

            Cell cell = board.getCell(fromX, fromY);
            if(fromX != toX && cell.getFigure() != null){
                return false;
            }

        }

        return checkCellTo(figure, to.getFigure());

    }

    private boolean checkVerticalWayFigure(Cell from, Cell to, Figure figure, Board board){

        char fromX = from.getX();
        int fromY = from.getY();

        int toY = to.getY();

        int changeY = (toY-fromY)/Math.abs(toY-fromY);

        while(fromY != toY){

            fromY += changeY;

            Cell cell = board.getCell(fromX, fromY);

            if(fromY != toY && cell.getFigure() != null){
                return false;
            }

        }

        return checkCellTo(figure, to.getFigure());

    }

    private boolean checkCellTo(Figure figureTo, Figure figureFrom){

        if(figureTo == null){
            return true;
        } else if(figureFrom.getColor() != figureFrom.getColor()){
            return true;
        } else {
            return false;
        }

    }

}
