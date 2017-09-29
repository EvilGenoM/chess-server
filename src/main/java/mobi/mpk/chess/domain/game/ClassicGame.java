package mobi.mpk.chess.domain.game;

import mobi.mpk.chess.domain.*;
import mobi.mpk.chess.domain.exception.CellCorrectException;
import mobi.mpk.chess.domain.exception.FigureNotFindException;
import mobi.mpk.chess.domain.exception.StrokeCorrectException;
import mobi.mpk.chess.domain.exception.rule.FigureCanNotMoveException;
import mobi.mpk.chess.domain.exception.rule.PossibleMoveException;
import mobi.mpk.chess.domain.exception.rule.WayFigureHaveObstaclesException;
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

    public ClassicGame(Player player1, Player player2) {

        this(player1, player2, new ClassicInspectorRules());

    }

    @Override
    public void initBoard() {

        Cell[][] cells = getBoard().getMassiveCell();

        List<Figure> orderWhiteFigure = getInspectorRules().getOrderFigure(Color.white);
        putWhiteFigures(cells, orderWhiteFigure);

        List<Figure> orderBlackFigure = getInspectorRules().getOrderFigure(Color.black);
        putBlackFigures(cells, orderBlackFigure);

    }

    private void putWhiteFigures(Cell[][] cells, List<Figure> orderFigures) {

        int x = 0;
        int y = 0;

        for (Figure figure : orderFigures) {
            cells[x][y].setFigure(figure);
            x++;
            if (x == 8) {
                x = 0;
                y++;
            }
        }

    }

    private void putBlackFigures(Cell[][] cells, List<Figure> orderFigures) {

        int x = 0;
        int y = 7;

        for (Figure figure : orderFigures) {
            cells[x][y].setFigure(figure);
            x++;
            if (x == 8) {
                x = 0;
                y--;
            }
        }

    }

    @Override
    public ResultStroke doStroke(Player player, String strokeStr) {

        try {

            Stroke stroke = new Stroke(strokeStr);
            stroke.findFigure(getBoard());

            if (player.getColorFigures() == nowStroke) {

                player.move(stroke, getBoard(), getInspectorRules());
                nextStroke();
                return new ResultStroke("Success move", true);

            } else {
                return new ResultStroke("Now is not your move", false);
            }

        } catch (CellCorrectException e) {
            return new ResultStroke("An incorrect cell is entered", false);
        } catch (StrokeCorrectException e) {
            return new ResultStroke("Incorrect move entered", false);
        } catch (FigureNotFindException e) {
            return new ResultStroke("This cell does not have a shape", false);
        } catch (FigureCanNotMoveException e) {
            return new ResultStroke("The figure does not know how to walk like that", false);
        } catch (PossibleMoveException e) {
            return new ResultStroke("This cell does not have your shape", false);
        } catch (WayFigureHaveObstaclesException e) {
            return new ResultStroke("The movement of the figure is prevented by other figures", false);
        } catch (Exception e) {
            return new ResultStroke("Exception", false);
        }

    }

    private void nextStroke() {

        if (nowStroke == Color.white) {
            nowStroke = Color.black;
        } else {
            nowStroke = Color.white;
        }

    }

    public List<Figure> getListFiguresOnBoard() {

        List<Figure> board = new LinkedList<Figure>();

        Cell[][] cells = getBoard().getMassiveCell();
        for (int y = 0; y < 8; y++) {

            for (int x = 0; x < 8; x++) {
                board.add(cells[x][y].getFigure());
            }

        }

        return board;
    }

}
