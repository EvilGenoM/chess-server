package obstaclemove;

import mobi.mpk.chess.domain.Board;
import mobi.mpk.chess.domain.Cell;
import mobi.mpk.chess.domain.Color;
import mobi.mpk.chess.domain.Stroke;
import mobi.mpk.chess.domain.exception.CellCorrectException;
import mobi.mpk.chess.domain.exception.FigureNotFindException;
import mobi.mpk.chess.domain.exception.StrokeCorrectException;
import mobi.mpk.chess.domain.figure.*;
import mobi.mpk.chess.domain.rules.rule.obstacle.move.ObstacleMoveDiagonalRule;
import mobi.mpk.chess.domain.rules.rule.obstacle.move.ObstacleMoveLineRule;
import mobi.mpk.chess.domain.rules.rule.obstacle.move.ObstacleMoveRule;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestObstacleMoveDiagonalRule {

    private Board board;

    @Before
    public void before() throws CellCorrectException {
        board = new Board();
        Cell cell = board.getCell('e',4);
        cell.setFigure(new Bishop(Color.white));

        cell = board.getCell('b', 1);
        cell.setFigure(new Queen(Color.white));

        cell = board.getCell('h', 1);
        cell.setFigure(new Pawn(Color.black));

        cell = board.getCell('g',6);
        cell.setFigure(new Bishop(Color.white));

        cell = board.getCell('b',7);
        cell.setFigure(new Knight(Color.white));
    }

    @Test
    public void testE4A5(){

        Stroke stroke = null;
        try {
            stroke = new Stroke("e4 a5");
            stroke.findFigure(board);

            ObstacleMoveRule rule = new ObstacleMoveDiagonalRule();
            boolean result = rule.checkRule(stroke, board);

            assertEquals(result, false);
        } catch (CellCorrectException e) {
            e.printStackTrace();
        } catch (StrokeCorrectException e) {
            e.printStackTrace();
        } catch (FigureNotFindException e) {
            e.printStackTrace();
        }

    }

    @Test
    public void testE4B1(){

        Stroke stroke = null;
        try {
            stroke = new Stroke("e4 b1");
            stroke.findFigure(board);

            ObstacleMoveRule rule = new ObstacleMoveDiagonalRule();
            boolean result = rule.checkRule(stroke, board);

            assertEquals(result, false);
        } catch (CellCorrectException e) {
            e.printStackTrace();
        } catch (StrokeCorrectException e) {
            e.printStackTrace();
        } catch (FigureNotFindException e) {
            e.printStackTrace();
        }

    }

    @Test
    public void testE4H1(){

        Stroke stroke = null;
        try {
            stroke = new Stroke("e4 h1");
            stroke.findFigure(board);

            ObstacleMoveRule rule = new ObstacleMoveDiagonalRule();
            boolean result = rule.checkRule(stroke, board);

            assertEquals(result, true);
        } catch (CellCorrectException e) {
            e.printStackTrace();
        } catch (StrokeCorrectException e) {
            e.printStackTrace();
        } catch (FigureNotFindException e) {
            e.printStackTrace();
        }

    }

    @Test
    public void testE4H7(){

        Stroke stroke = null;
        try {
            stroke = new Stroke("e4 h7");
            stroke.findFigure(board);

            ObstacleMoveRule rule = new ObstacleMoveDiagonalRule();
            boolean result = rule.checkRule(stroke, board);

            assertEquals(result, false);
        } catch (CellCorrectException e) {
            e.printStackTrace();
        } catch (StrokeCorrectException e) {
            e.printStackTrace();
        } catch (FigureNotFindException e) {
            e.printStackTrace();
        }

    }

    @Test
    public void testE4C2(){

        Stroke stroke = null;
        try {
            stroke = new Stroke("e4 c2");
            stroke.findFigure(board);

            ObstacleMoveRule rule = new ObstacleMoveDiagonalRule();
            boolean result = rule.checkRule(stroke, board);

            assertEquals(result, true);
        } catch (CellCorrectException e) {
            e.printStackTrace();
        } catch (StrokeCorrectException e) {
            e.printStackTrace();
        } catch (FigureNotFindException e) {
            e.printStackTrace();
        }

    }

}
