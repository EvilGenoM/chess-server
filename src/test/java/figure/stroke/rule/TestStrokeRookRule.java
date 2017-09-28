package figure.stroke.rule;

import mobi.mpk.chess.domain.Board;
import mobi.mpk.chess.domain.Cell;
import mobi.mpk.chess.domain.Color;
import mobi.mpk.chess.domain.Stroke;
import mobi.mpk.chess.domain.exception.CellCorrectException;
import mobi.mpk.chess.domain.exception.FigureNotFindException;
import mobi.mpk.chess.domain.exception.StrokeCorrectException;
import mobi.mpk.chess.domain.figure.Rook;
import mobi.mpk.chess.domain.rules.rule.stoke.figure.StrokeFigureRule;
import mobi.mpk.chess.domain.rules.rule.stoke.figure.StrokeRookRule;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestStrokeRookRule {

    private Board board;

    @Before
    public void before() throws CellCorrectException {

        board = new Board();

        Cell cell = new Cell('a',1);
        cell = board.getCell(cell);
        cell.setFigure(new Rook(Color.white));

        cell = new Cell('h',1);
        cell = board.getCell(cell);
        cell.setFigure(new Rook(Color.white));

    }

    @Test
    public void testA1A2(){

        StrokeFigureRule strokeFigureRule = new StrokeRookRule();

        Stroke stroke = null;
        try {
            stroke = new Stroke("a1 a2");
            stroke.findFigure(board);
        } catch (CellCorrectException e) {
            e.printStackTrace();
        } catch (StrokeCorrectException e) {
            e.printStackTrace();
        } catch (FigureNotFindException e) {
            e.printStackTrace();
        }
        boolean resultStroke = strokeFigureRule.checkRule(stroke);

        assertEquals(resultStroke, true);

    }

    @Test
    public void testA1B1(){

        StrokeFigureRule strokeFigureRule = new StrokeRookRule();

        Stroke stroke = null;
        try {
            stroke = new Stroke("a1 b1");
            stroke.findFigure(board);
        } catch (CellCorrectException e) {
            e.printStackTrace();
        } catch (StrokeCorrectException e) {
            e.printStackTrace();
        } catch (FigureNotFindException e) {
            e.printStackTrace();
        }
        boolean resultStroke = strokeFigureRule.checkRule(stroke);

        assertEquals(resultStroke, true);

    }

    @Test
    public void testA1A6(){

        StrokeFigureRule strokeFigureRule = new StrokeRookRule();

        Stroke stroke = null;
        try {
            stroke = new Stroke("a1 a6");
            stroke.findFigure(board);
        } catch (CellCorrectException e) {
            e.printStackTrace();
        } catch (StrokeCorrectException e) {
            e.printStackTrace();
        } catch (FigureNotFindException e) {
            e.printStackTrace();
        }
        boolean resultStroke = strokeFigureRule.checkRule(stroke);

        assertEquals(resultStroke, true);

    }

    @Test
    public void testA1H1(){

        StrokeFigureRule strokeFigureRule = new StrokeRookRule();

        Stroke stroke = null;
        try {
            stroke = new Stroke("a1 h1");
            stroke.findFigure(board);
        } catch (CellCorrectException e) {
            e.printStackTrace();
        } catch (StrokeCorrectException e) {
            e.printStackTrace();
        } catch (FigureNotFindException e) {
            e.printStackTrace();
        }
        boolean resultStroke = strokeFigureRule.checkRule(stroke);

        assertEquals(resultStroke, true);

    }

    @Test
    public void testA1B2(){

        StrokeFigureRule strokeFigureRule = new StrokeRookRule();

        Stroke stroke = null;
        try {
            stroke = new Stroke("a1 b2");
            stroke.findFigure(board);
        } catch (CellCorrectException e) {
            e.printStackTrace();
        } catch (StrokeCorrectException e) {
            e.printStackTrace();
        } catch (FigureNotFindException e) {
            e.printStackTrace();
        }
        boolean resultStroke = strokeFigureRule.checkRule(stroke);

        assertEquals(resultStroke, false);

    }

    @Test
    public void testH1A1(){

        StrokeFigureRule strokeFigureRule = new StrokeRookRule();

        Stroke stroke = null;
        try {
            stroke = new Stroke("h1 a1");
            stroke.findFigure(board);
        } catch (CellCorrectException e) {
            e.printStackTrace();
        } catch (StrokeCorrectException e) {
            e.printStackTrace();
        } catch (FigureNotFindException e) {
            e.printStackTrace();
        }
        boolean resultStroke = strokeFigureRule.checkRule(stroke);

        assertEquals(resultStroke, true);

    }

    @Test
    public void testH1H7(){

        StrokeFigureRule strokeFigureRule = new StrokeRookRule();

        Stroke stroke = null;
        try {
            stroke = new Stroke("h1 h7");
            stroke.findFigure(board);
        } catch (CellCorrectException e) {
            e.printStackTrace();
        } catch (StrokeCorrectException e) {
            e.printStackTrace();
        } catch (FigureNotFindException e) {
            e.printStackTrace();
        }
        boolean resultStroke = strokeFigureRule.checkRule(stroke);

        assertEquals(resultStroke, true);

    }

    @Test
    public void testH1A7(){

        StrokeFigureRule strokeFigureRule = new StrokeRookRule();

        Stroke stroke = null;
        try {
            stroke = new Stroke("h1 a7");
            stroke.findFigure(board);
        } catch (CellCorrectException e) {
            e.printStackTrace();
        } catch (StrokeCorrectException e) {
            e.printStackTrace();
        } catch (FigureNotFindException e) {
            e.printStackTrace();
        }
        boolean resultStroke = strokeFigureRule.checkRule(stroke);

        assertEquals(resultStroke, false);

    }

}
