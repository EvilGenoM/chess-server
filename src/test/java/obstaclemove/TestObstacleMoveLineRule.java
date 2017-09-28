package obstaclemove;

import mobi.mpk.chess.domain.Board;
import mobi.mpk.chess.domain.Cell;
import mobi.mpk.chess.domain.Color;
import mobi.mpk.chess.domain.Stroke;
import mobi.mpk.chess.domain.exception.CellCorrectException;
import mobi.mpk.chess.domain.exception.FigureNotFindException;
import mobi.mpk.chess.domain.exception.StrokeCorrectException;
import mobi.mpk.chess.domain.figure.Pawn;
import mobi.mpk.chess.domain.figure.Queen;
import mobi.mpk.chess.domain.figure.Rook;
import mobi.mpk.chess.domain.rules.rule.obstacle.move.ObstacleMoveLineRule;
import mobi.mpk.chess.domain.rules.rule.obstacle.move.ObstacleMoveRule;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestObstacleMoveLineRule {

    private Board board;

    @Before
    public void before() throws CellCorrectException {
        board = new Board();
        Cell cell = board.getCell('a',1);
        cell.setFigure(new Rook(Color.white));

        cell = board.getCell('a', 6);
        cell.setFigure(new Queen(Color.white));

        cell = board.getCell('g', 1);
        cell.setFigure(new Pawn(Color.black));
    }

    @Test
    public void testA1A5(){

        Stroke stroke = null;
        try {
            stroke = new Stroke("a1 a5");
            stroke.findFigure(board);

            ObstacleMoveRule rule = new ObstacleMoveLineRule();
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
    public void testA1A6(){

        Stroke stroke = null;
        try {
            stroke = new Stroke("a1 a6");
            stroke.findFigure(board);

            ObstacleMoveRule rule = new ObstacleMoveLineRule();
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
    public void testA1A7(){

        Stroke stroke = null;
        try {
            stroke = new Stroke("a1 a7");
            stroke.findFigure(board);

            ObstacleMoveRule rule = new ObstacleMoveLineRule();
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
    public void testA1G1(){

        Stroke stroke = null;
        try {
            stroke = new Stroke("a1 g1");
            stroke.findFigure(board);

            ObstacleMoveRule rule = new ObstacleMoveLineRule();
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
    public void testA1H1(){

        Stroke stroke = null;
        try {
            stroke = new Stroke("a1 h1");
            stroke.findFigure(board);

            ObstacleMoveRule rule = new ObstacleMoveLineRule();
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
