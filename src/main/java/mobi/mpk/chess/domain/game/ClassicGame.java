package mobi.mpk.chess.domain.game;

import mobi.mpk.chess.domain.*;
import mobi.mpk.chess.domain.exception.CellCorrectException;
import mobi.mpk.chess.domain.exception.StrokeCorrectException;
import mobi.mpk.chess.domain.figure.Figure;
import mobi.mpk.chess.domain.rules.ClassicInspectorRules;
import mobi.mpk.chess.domain.rules.InspectorRules;

import java.util.LinkedList;
import java.util.List;

public class ClassicGame extends Game {

    private Color nowStroke = Color.white;

    public ClassicGame(Player player1, Player player2, InspectorRules InspectorRules) {

        super(player1, player2, InspectorRules);
        initBoard();

    }

    public ClassicGame(Player player1, Player player2){

        this(player1, player2, new ClassicInspectorRules());

    }

    @Override
    public void initBoard() {

        Cell[][] cells = getBoard().getMassiveCell();

        //List<Figure> orderWhiteFigure = getInspectorRules().orderFigure(Color.white);
        //putWhiteFigures(cells, orderWhiteFigure);

        //List<Figure> orderBlackFigure = getInspectorRules().orderFigure(Color.black);
        //putBlackFigures(cells, orderBlackFigure);

    }

    private void putWhiteFigures(Cell[][] cells, List<Figure> orderFigures){

        int x = 0;
        int y = 0;

        for(Figure figure : orderFigures){
            cells[x][y].setFigure(figure);
            x++;
            if(x == 8){
                x = 0;
                y++;
            }
        }

    }

    private void putBlackFigures(Cell[][] cells, List<Figure> orderFigures){

        int x = 0;
        int y = 7;

        for(Figure figure : orderFigures){
            cells[x][y].setFigure(figure);
            x++;
            if(x == 8){
                x = 0;
                y--;
            }
        }

    }

    @Override
    public ResultStroke doStroke(Player player, String strokeStr) {

        if(player.getColorFigures() == nowStroke){

            try {
                Stroke stroke = new Stroke(strokeStr);
            } catch (CellCorrectException e) {
                e.printStackTrace();
            } catch (StrokeCorrectException e) {
                e.printStackTrace();
            }
            //ResultStroke resultStroke = player.move(stroke, getBoard(), getInspectorRules());
            //if(resultStroke.isSuccess()){
              //  nextStroke();
            //}

            //return resultStroke;

        } else {

            ResultStroke resultStroke = new ResultStroke("Not your move", false);
            return resultStroke;

        }
        return null;
    }

    private void nextStroke(){

        if(nowStroke == Color.white){
            nowStroke = Color.black;
        } else {
            nowStroke = Color.white;
        }

    }

    public List<Figure> getListFiguresOnBoard(){

        List<Figure> board = new LinkedList<Figure>();

        Cell[][] cells = getBoard().getMassiveCell();
        for(int y = 0; y<8; y++){

            for (int x = 0; x<8; x++){
                board.add(cells[x][y].getFigure());
            }

        }

        return board;
    }

}
