package figure.stroke.rule;

import mobi.mpk.chess.domain.Stroke;
import mobi.mpk.chess.domain.exception.CellCorrectException;
import mobi.mpk.chess.domain.exception.StrokeCorrectException;
import mobi.mpk.chess.domain.rules.rule.stoke.figure.StrokeBishopRule;
import mobi.mpk.chess.domain.rules.rule.stoke.figure.StrokeFigureRule;
import mobi.mpk.chess.domain.rules.rule.stoke.figure.StrokeQueenRule;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestStrokeQueenRule {

    @Test
    public void testA1B2(){

        StrokeFigureRule strokeFigureRule = new StrokeQueenRule();

        Stroke stroke = null;
        try {
            stroke = new Stroke("a1 b2");
        } catch (CellCorrectException e) {
            e.printStackTrace();
        } catch (StrokeCorrectException e) {
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
        } catch (CellCorrectException e) {
            e.printStackTrace();
        } catch (StrokeCorrectException e) {
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
        } catch (CellCorrectException e) {
            e.printStackTrace();
        } catch (StrokeCorrectException e) {
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
        } catch (CellCorrectException e) {
            e.printStackTrace();
        } catch (StrokeCorrectException e) {
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
        } catch (CellCorrectException e) {
            e.printStackTrace();
        } catch (StrokeCorrectException e) {
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
        } catch (CellCorrectException e) {
            e.printStackTrace();
        } catch (StrokeCorrectException e) {
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
        } catch (CellCorrectException e) {
            e.printStackTrace();
        } catch (StrokeCorrectException e) {
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
        } catch (CellCorrectException e) {
            e.printStackTrace();
        } catch (StrokeCorrectException e) {
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
        } catch (CellCorrectException e) {
            e.printStackTrace();
        } catch (StrokeCorrectException e) {
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
        } catch (CellCorrectException e) {
            e.printStackTrace();
        } catch (StrokeCorrectException e) {
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
        } catch (CellCorrectException e) {
            e.printStackTrace();
        } catch (StrokeCorrectException e) {
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
        } catch (CellCorrectException e) {
            e.printStackTrace();
        } catch (StrokeCorrectException e) {
            e.printStackTrace();
        }
        boolean resultStroke = strokeFigureRule.strokeFigureRule(stroke);

        assertEquals(resultStroke, false);

    }

}
