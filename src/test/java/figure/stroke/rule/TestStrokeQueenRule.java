package figure.stroke.rule;

import mobi.mpk.chess.domain.Board;
import mobi.mpk.chess.domain.Cell;
import mobi.mpk.chess.domain.Color;
import mobi.mpk.chess.domain.Stroke;
import mobi.mpk.chess.domain.exception.CellCorrectException;
import mobi.mpk.chess.domain.exception.FigureNotFindException;
import mobi.mpk.chess.domain.exception.StrokeCorrectException;
import mobi.mpk.chess.domain.figure.Bishop;
import mobi.mpk.chess.domain.figure.Queen;
import mobi.mpk.chess.domain.rules.rule.stoke.figure.StrokeBishopRule;
import mobi.mpk.chess.domain.rules.rule.stoke.figure.StrokeFigureRule;
import mobi.mpk.chess.domain.rules.rule.stoke.figure.StrokeQueenRule;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestStrokeQueenRule {

    private Board board;

    @Before
    public void before() throws CellCorrectException {

        board = new Board();

        Cell cell = new Cell('a',1);
        cell = board.getCell(cell);
        cell.setFigure(new Queen(Color.white));

        cell = new Cell('e',4);
        cell = board.getCell(cell);
        cell.setFigure(new Queen(Color.white));

    }

    @Test
    public void testA1B2(){

        StrokeFigureRule strokeFigureRule = new StrokeQueenRule();

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
        boolean resultStroke = strokeFigureRule.strokeFigureRule(stroke);

        assertEquals(resultStroke, true);

    }

    @Test
    public void testA1A2(){

        StrokeFigureRule strokeFigureRule = new StrokeQueenRule();

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
        boolean resultStroke = strokeFigureRule.strokeFigureRule(stroke);

        assertEquals(resultStroke, true);

    }

    @Test
    public void testA1B1(){

        StrokeFigureRule strokeFigureRule = new StrokeQueenRule();

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
        boolean resultStroke = strokeFigureRule.strokeFigureRule(stroke);

        assertEquals(resultStroke, true);

    }

    @Test
    public void testE4B2(){

        StrokeFigureRule strokeFigureRule = new StrokeQueenRule();

        Stroke stroke = null;
        try {
            stroke = new Stroke("e4 b1");
            stroke.findFigure(board);
        } catch (CellCorrectException e) {
            e.printStackTrace();
        } catch (StrokeCorrectException e) {
            e.printStackTrace();
        } catch (FigureNotFindException e) {
            e.printStackTrace();
        }
        boolean resultStroke = strokeFigureRule.strokeFigureRule(stroke);

        assertEquals(resultStroke, true);

    }

    @Test
    public void testE4H1(){

        StrokeFigureRule strokeFigureRule = new StrokeQueenRule();

        Stroke stroke = null;
        try {
            stroke = new Stroke("e4 h1");
            stroke.findFigure(board);
        } catch (CellCorrectException e) {
            e.printStackTrace();
        } catch (StrokeCorrectException e) {
            e.printStackTrace();
        } catch (FigureNotFindException e) {
            e.printStackTrace();
        }
        boolean resultStroke = strokeFigureRule.strokeFigureRule(stroke);

        assertEquals(resultStroke, true);

    }

    @Test
    public void testE4H7(){

        StrokeFigureRule strokeFigureRule = new StrokeQueenRule();

        Stroke stroke = null;
        try {
            stroke = new Stroke("e4 h7");
            stroke.findFigure(board);
        } catch (CellCorrectException e) {
            e.printStackTrace();
        } catch (StrokeCorrectException e) {
            e.printStackTrace();
        } catch (FigureNotFindException e) {
            e.printStackTrace();
        }
        boolean resultStroke = strokeFigureRule.strokeFigureRule(stroke);

        assertEquals(resultStroke, true);

    }

    @Test
    public void testE4B7(){

        StrokeFigureRule strokeFigureRule = new StrokeQueenRule();

        Stroke stroke = null;
        try {
            stroke = new Stroke("e4 b7");
            stroke.findFigure(board);
        } catch (CellCorrectException e) {
            e.printStackTrace();
        } catch (StrokeCorrectException e) {
            e.printStackTrace();
        } catch (FigureNotFindException e) {
            e.printStackTrace();
        }
        boolean resultStroke = strokeFigureRule.strokeFigureRule(stroke);

        assertEquals(resultStroke, true);

    }

    @Test
    public void testE4E8(){

        StrokeFigureRule strokeFigureRule = new StrokeQueenRule();

        Stroke stroke = null;
        try {
            stroke = new Stroke("e4 e8");
            stroke.findFigure(board);
        } catch (CellCorrectException e) {
            e.printStackTrace();
        } catch (StrokeCorrectException e) {
            e.printStackTrace();
        } catch (FigureNotFindException e) {
            e.printStackTrace();
        }
        boolean resultStroke = strokeFigureRule.strokeFigureRule(stroke);

        assertEquals(resultStroke, true);

    }

    @Test
    public void testE4E1(){

        StrokeFigureRule strokeFigureRule = new StrokeQueenRule();

        Stroke stroke = null;
        try {
            stroke = new Stroke("e4 e1");
            stroke.findFigure(board);
        } catch (CellCorrectException e) {
            e.printStackTrace();
        } catch (StrokeCorrectException e) {
            e.printStackTrace();
        } catch (FigureNotFindException e) {
            e.printStackTrace();
        }
        boolean resultStroke = strokeFigureRule.strokeFigureRule(stroke);

        assertEquals(resultStroke, true);

    }

    @Test
    public void testE4A4(){

        StrokeFigureRule strokeFigureRule = new StrokeQueenRule();

        Stroke stroke = null;
        try {
            stroke = new Stroke("e4 a4");
            stroke.findFigure(board);
        } catch (CellCorrectException e) {
            e.printStackTrace();
        } catch (StrokeCorrectException e) {
            e.printStackTrace();
        } catch (FigureNotFindException e) {
            e.printStackTrace();
        }
        boolean resultStroke = strokeFigureRule.strokeFigureRule(stroke);

        assertEquals(resultStroke, true);

    }

    @Test
    public void testE4H4(){

        StrokeFigureRule strokeFigureRule = new StrokeQueenRule();

        Stroke stroke = null;
        try {
            stroke = new Stroke("e4 h4");
            stroke.findFigure(board);
        } catch (CellCorrectException e) {
            e.printStackTrace();
        } catch (StrokeCorrectException e) {
            e.printStackTrace();
        } catch (FigureNotFindException e) {
            e.printStackTrace();
        }
        boolean resultStroke = strokeFigureRule.strokeFigureRule(stroke);

        assertEquals(resultStroke, true);

    }

    @Test
    public void testE4F6(){

        StrokeFigureRule strokeFigureRule = new StrokeQueenRule();

        Stroke stroke = null;
        try {
            stroke = new Stroke("e4 f6");
            stroke.findFigure(board);
        } catch (CellCorrectException e) {
            e.printStackTrace();
        } catch (StrokeCorrectException e) {
            e.printStackTrace();
        } catch (FigureNotFindException e) {
            e.printStackTrace();
        }
        boolean resultStroke = strokeFigureRule.strokeFigureRule(stroke);

        assertEquals(resultStroke, false);

    }

}
