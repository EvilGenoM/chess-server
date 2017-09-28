package stroke.figure.rule;

import mobi.mpk.chess.domain.Stroke;
import mobi.mpk.chess.domain.exception.CellCorrectException;
import mobi.mpk.chess.domain.exception.StrokeCorrectException;
import mobi.mpk.chess.domain.rules.rule.stoke.figure.StrokeFigureRule;
import mobi.mpk.chess.domain.rules.rule.stoke.figure.StrokeKingRule;
import mobi.mpk.chess.domain.rules.rule.stoke.figure.StrokeKnightRule;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestStrokeKnightRule {

    @Test
    public void testA1A2(){

        StrokeFigureRule strokeFigureRule = new StrokeKnightRule();

        Stroke stroke = null;
        try {
            stroke = new Stroke("a1 a2");
        } catch (CellCorrectException e) {
            e.printStackTrace();
        } catch (StrokeCorrectException e) {
            e.printStackTrace();
        }
        boolean resultStroke = strokeFigureRule.strokeFigureRule(stroke);

        assertEquals(resultStroke, false);

    }

    @Test
    public void testD5E3(){

        StrokeFigureRule strokeFigureRule = new StrokeKnightRule();

        Stroke stroke = null;
        try {
            stroke = new Stroke("d5 e3");
        } catch (CellCorrectException e) {
            e.printStackTrace();
        } catch (StrokeCorrectException e) {
            e.printStackTrace();
        }
        boolean resultStroke = strokeFigureRule.strokeFigureRule(stroke);

        assertEquals(resultStroke, true);

    }

    @Test
    public void testD5C3(){

        StrokeFigureRule strokeFigureRule = new StrokeKnightRule();

        Stroke stroke = null;
        try {
            stroke = new Stroke("d5 c3");
        } catch (CellCorrectException e) {
            e.printStackTrace();
        } catch (StrokeCorrectException e) {
            e.printStackTrace();
        }
        boolean resultStroke = strokeFigureRule.strokeFigureRule(stroke);

        assertEquals(resultStroke, true);

    }

    @Test
    public void testD5F4(){

        StrokeFigureRule strokeFigureRule = new StrokeKnightRule();

        Stroke stroke = null;
        try {
            stroke = new Stroke("d5 f4");
        } catch (CellCorrectException e) {
            e.printStackTrace();
        } catch (StrokeCorrectException e) {
            e.printStackTrace();
        }
        boolean resultStroke = strokeFigureRule.strokeFigureRule(stroke);

        assertEquals(resultStroke, true);

    }

    @Test
    public void testD5B4(){

        StrokeFigureRule strokeFigureRule = new StrokeKnightRule();

        Stroke stroke = null;
        try {
            stroke = new Stroke("d5 b4");
        } catch (CellCorrectException e) {
            e.printStackTrace();
        } catch (StrokeCorrectException e) {
            e.printStackTrace();
        }
        boolean resultStroke = strokeFigureRule.strokeFigureRule(stroke);

        assertEquals(resultStroke, true);

    }

    @Test
    public void testD5F6(){

        StrokeFigureRule strokeFigureRule = new StrokeKnightRule();

        Stroke stroke = null;
        try {
            stroke = new Stroke("d5 f6");
        } catch (CellCorrectException e) {
            e.printStackTrace();
        } catch (StrokeCorrectException e) {
            e.printStackTrace();
        }
        boolean resultStroke = strokeFigureRule.strokeFigureRule(stroke);

        assertEquals(resultStroke, true);

    }

    @Test
    public void testD5B6(){

        StrokeFigureRule strokeFigureRule = new StrokeKnightRule();

        Stroke stroke = null;
        try {
            stroke = new Stroke("d5 b6");
        } catch (CellCorrectException e) {
            e.printStackTrace();
        } catch (StrokeCorrectException e) {
            e.printStackTrace();
        }
        boolean resultStroke = strokeFigureRule.strokeFigureRule(stroke);

        assertEquals(resultStroke, true);

    }

    @Test
    public void testD5C7(){

        StrokeFigureRule strokeFigureRule = new StrokeKnightRule();

        Stroke stroke = null;
        try {
            stroke = new Stroke("d5 c7");
        } catch (CellCorrectException e) {
            e.printStackTrace();
        } catch (StrokeCorrectException e) {
            e.printStackTrace();
        }
        boolean resultStroke = strokeFigureRule.strokeFigureRule(stroke);

        assertEquals(resultStroke, true);

    }

    @Test
    public void testD5E7(){

        StrokeFigureRule strokeFigureRule = new StrokeKnightRule();

        Stroke stroke = null;
        try {
            stroke = new Stroke("d5 e7");
        } catch (CellCorrectException e) {
            e.printStackTrace();
        } catch (StrokeCorrectException e) {
            e.printStackTrace();
        }
        boolean resultStroke = strokeFigureRule.strokeFigureRule(stroke);

        assertEquals(resultStroke, true);

    }

}
