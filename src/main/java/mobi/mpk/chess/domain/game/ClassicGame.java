package mobi.mpk.chess.domain.game;

import mobi.mpk.chess.domain.Cell;
import mobi.mpk.chess.domain.Color;
import mobi.mpk.chess.domain.Player;
import mobi.mpk.chess.domain.figure.Figure;
import mobi.mpk.chess.domain.rule.ClassicRules;
import mobi.mpk.chess.domain.rule.Rules;

import java.util.LinkedList;
import java.util.List;

public class ClassicGame extends Game {

    private Color nowStroke = Color.white;

    public ClassicGame(Player player1, Player player2, Rules rules) {

        super(player1, player2, rules);
        initBoard();

    }

    public ClassicGame(Player player1, Player player2){

        this(player1, player2, new ClassicRules());

    }

    @Override
    public void initBoard() {

        Cell[][] cells = getBoard().getMassiveCell();

        List<Figure> orderWhiteFigure = getInspectorRules().orderFigure(Color.white);
        putWhiteFigures(cells, orderWhiteFigure);

        List<Figure> orderBlackFigure = getInspectorRules().orderFigure(Color.black);
        putBlackFigures(cells, orderBlackFigure);

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

            Stroke stroke = new Stroke(strokeStr);
            ResultStroke resultStroke = player.move(stroke, getBoard(), getInspectorRules());
            if(resultStroke.isSuccess()){
                nextStroke();
            }

            return resultStroke;

        } else {

            ResultStroke resultStroke = new ResultStroke("Not your move", false);
            return resultStroke;

        }
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
