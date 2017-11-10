package mobi.mpk.chessServerSpring.domain.rules.rule;

import mobi.mpk.chessServerSpring.domain.Board;
import mobi.mpk.chessServerSpring.domain.Cell;
import mobi.mpk.chessServerSpring.domain.Color;
import mobi.mpk.chessServerSpring.domain.Stroke;
import mobi.mpk.chessServerSpring.domain.exception.CellCorrectException;
import mobi.mpk.chessServerSpring.domain.exception.FigureNotFindException;
import mobi.mpk.chessServerSpring.domain.exception.StrokeCorrectException;
import mobi.mpk.chessServerSpring.domain.figure.King;
import mobi.mpk.chessServerSpring.domain.rules.rule.stoke.figure.StrokeFigureRule;
import mobi.mpk.chessServerSpring.domain.rules.rule.stoke.figure.StrokeKingRule;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestStrokeKingRule {

    private Board board;

    @Before
    public void before() throws CellCorrectException {

        board = new Board();

        Cell cell = new Cell('a',1);
        cell = board.getCell(cell);
        cell.setFigure(new King(Color.white));

        cell = new Cell('c',3);
        cell = board.getCell(cell);
        cell.setFigure(new King(Color.white));

    }

    @Test
    public void testA1A2(){

        StrokeFigureRule strokeFigureRule = new StrokeKingRule();

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

        StrokeFigureRule strokeFigureRule = new StrokeKingRule();

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
    public void testA1B2(){

        StrokeFigureRule strokeFigureRule = new StrokeKingRule();

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

        assertEquals(resultStroke, true);
    }

    @Test
    public void testC3B3(){

        StrokeFigureRule strokeFigureRule = new StrokeKingRule();

        Stroke stroke = null;
        try {
            stroke = new Stroke("c3 b3");
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
    public void testC3B4(){

        StrokeFigureRule strokeFigureRule = new StrokeKingRule();

        Stroke stroke = null;
        try {
            stroke = new Stroke("c3 b4");
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
    public void testC3C2(){

        StrokeFigureRule strokeFigureRule = new StrokeKingRule();

        Stroke stroke = null;
        try {
            stroke = new Stroke("c3 c2");
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
    public void testC3B2(){

        StrokeFigureRule strokeFigureRule = new StrokeKingRule();

        Stroke stroke = null;
        try {
            stroke = new Stroke("c3 b2");
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
    public void testC3D2(){

        StrokeFigureRule strokeFigureRule = new StrokeKingRule();

        Stroke stroke = null;
        try {
            stroke = new Stroke("c3 d2");
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
    public void testA1A3(){

        StrokeFigureRule strokeFigureRule = new StrokeKingRule();

        Stroke stroke = null;
        try {
            stroke = new Stroke("a1 a3");
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
