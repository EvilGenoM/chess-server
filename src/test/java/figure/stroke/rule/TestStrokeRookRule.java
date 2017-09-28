package figure.stroke.rule;

import mobi.mpk.chess.domain.Stroke;
import mobi.mpk.chess.domain.exception.CellCorrectException;
import mobi.mpk.chess.domain.exception.StrokeCorrectException;
import mobi.mpk.chess.domain.rules.rule.stoke.figure.StrokeFigureRule;
import mobi.mpk.chess.domain.rules.rule.stoke.figure.StrokeKnightRule;
import mobi.mpk.chess.domain.rules.rule.stoke.figure.StrokeRookRule;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestStrokeRookRule {

    @Test
    public void testA1A2(){

        StrokeFigureRule strokeFigureRule = new StrokeRookRule();

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

        StrokeFigureRule strokeFigureRule = new StrokeRookRule();

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
    public void testA1A6(){

        StrokeFigureRule strokeFigureRule = new StrokeRookRule();

        Stroke stroke = null;
        try {
            stroke = new Stroke("a1 a6");
        } catch (CellCorrectException e) {
            e.printStackTrace();
        } catch (StrokeCorrectException e) {
            e.printStackTrace();
        }
        boolean resultStroke = strokeFigureRule.strokeFigureRule(stroke);

        assertEquals(resultStroke, true);

    }

    @Test
    public void testA1H1(){

        StrokeFigureRule strokeFigureRule = new StrokeRookRule();

        Stroke stroke = null;
        try {
            stroke = new Stroke("a1 h1");
        } catch (CellCorrectException e) {
            e.printStackTrace();
        } catch (StrokeCorrectException e) {
            e.printStackTrace();
        }
        boolean resultStroke = strokeFigureRule.strokeFigureRule(stroke);

        assertEquals(resultStroke, true);

    }

    @Test
    public void testA1B2(){

        StrokeFigureRule strokeFigureRule = new StrokeRookRule();

        Stroke stroke = null;
        try {
            stroke = new Stroke("a1 b2");
        } catch (CellCorrectException e) {
            e.printStackTrace();
        } catch (StrokeCorrectException e) {
            e.printStackTrace();
        }
        boolean resultStroke = strokeFigureRule.strokeFigureRule(stroke);

        assertEquals(resultStroke, false);

    }

    @Test
    public void testH1A1(){

        StrokeFigureRule strokeFigureRule = new StrokeRookRule();

        Stroke stroke = null;
        try {
            stroke = new Stroke("h1 a1");
        } catch (CellCorrectException e) {
            e.printStackTrace();
        } catch (StrokeCorrectException e) {
            e.printStackTrace();
        }
        boolean resultStroke = strokeFigureRule.strokeFigureRule(stroke);

        assertEquals(resultStroke, true);

    }

    @Test
    public void testH1H7(){

        StrokeFigureRule strokeFigureRule = new StrokeRookRule();

        Stroke stroke = null;
        try {
            stroke = new Stroke("h1 h7");
        } catch (CellCorrectException e) {
            e.printStackTrace();
        } catch (StrokeCorrectException e) {
            e.printStackTrace();
        }
        boolean resultStroke = strokeFigureRule.strokeFigureRule(stroke);

        assertEquals(resultStroke, true);

    }

    @Test
    public void testH1A7(){

        StrokeFigureRule strokeFigureRule = new StrokeRookRule();

        Stroke stroke = null;
        try {
            stroke = new Stroke("h1 a7");
        } catch (CellCorrectException e) {
            e.printStackTrace();
        } catch (StrokeCorrectException e) {
            e.printStackTrace();
        }
        boolean resultStroke = strokeFigureRule.strokeFigureRule(stroke);

        assertEquals(resultStroke, false);

    }

}
