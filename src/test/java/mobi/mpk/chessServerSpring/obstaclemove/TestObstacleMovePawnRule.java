package mobi.mpk.chessServerSpring.obstaclemove;

import mobi.mpk.chessServerSpring.domain.Board;
import mobi.mpk.chessServerSpring.domain.Cell;
import mobi.mpk.chessServerSpring.domain.Color;
import mobi.mpk.chessServerSpring.domain.Stroke;
import mobi.mpk.chessServerSpring.domain.exception.CellCorrectException;
import mobi.mpk.chessServerSpring.domain.exception.FigureNotFindException;
import mobi.mpk.chessServerSpring.domain.exception.StrokeCorrectException;
import mobi.mpk.chessServerSpring.domain.figure.*;
import mobi.mpk.chessServerSpring.domain.rules.rule.obstacle.move.ObstacleMoveDiagonalRule;
import mobi.mpk.chessServerSpring.domain.rules.rule.obstacle.move.ObstacleMovePawnRule;
import mobi.mpk.chessServerSpring.domain.rules.rule.obstacle.move.ObstacleMoveRule;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestObstacleMovePawnRule {

    private Board board;

    @Before
    public void before() throws CellCorrectException {
        board = new Board();
        Cell cell = board.getCell('e',4);
        cell.setFigure(new Pawn(Color.white));

        cell = board.getCell('d', 5);
        cell.setFigure(new Queen(Color.black));

        cell = board.getCell('f', 3);
        cell.setFigure(new Pawn(Color.white));

        cell = board.getCell('e',5);
        cell.setFigure(new Rook(Color.white));

        cell = board.getCell('e',6);
        cell.setFigure(new Rook(Color.black));

        cell = board.getCell('e',2);
        cell.setFigure(new Knight(Color.white));
    }

    @Test
    public void testE4E6(){

        Stroke stroke = null;
        try {
            stroke = new Stroke("e4 e6");
            stroke.findFigure(board);

            ObstacleMoveRule rule = new ObstacleMovePawnRule();
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
    public void testE4E5(){

        Stroke stroke = null;
        try {
            stroke = new Stroke("e4 e5");
            stroke.findFigure(board);

            ObstacleMoveRule rule = new ObstacleMovePawnRule();
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
    public void testE4E3(){

        Stroke stroke = null;
        try {
            stroke = new Stroke("e4 e3");
            stroke.findFigure(board);

            ObstacleMoveRule rule = new ObstacleMovePawnRule();
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
    public void testE4E2(){

        Stroke stroke = null;
        try {
            stroke = new Stroke("e4 e2");
            stroke.findFigure(board);

            ObstacleMoveRule rule = new ObstacleMovePawnRule();
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
    public void testE4D5(){

        Stroke stroke = null;
        try {
            stroke = new Stroke("e4 d5");
            stroke.findFigure(board);

            ObstacleMoveRule rule = new ObstacleMovePawnRule();
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
    public void testE4F3(){

        Stroke stroke = null;
        try {
            stroke = new Stroke("e4 f3");
            stroke.findFigure(board);

            ObstacleMoveRule rule = new ObstacleMovePawnRule();
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
    public void testE4F5(){

        Stroke stroke = null;
        try {
            stroke = new Stroke("e4 f5");
            stroke.findFigure(board);

            ObstacleMoveRule rule = new ObstacleMovePawnRule();
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
    public void testD5D6(){

        Stroke stroke = null;
        try {
            stroke = new Stroke("d5 d6");
            stroke.findFigure(board);

            ObstacleMoveRule rule = new ObstacleMovePawnRule();
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

}
