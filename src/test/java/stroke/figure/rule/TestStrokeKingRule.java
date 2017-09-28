package stroke.figure.rule;

import mobi.mpk.chess.domain.Stroke;
import mobi.mpk.chess.domain.exception.CellCorrectException;
import mobi.mpk.chess.domain.exception.StrokeCorrectException;
import mobi.mpk.chess.domain.rules.rule.stoke.figure.StrokeFigureRule;
import mobi.mpk.chess.domain.rules.rule.stoke.figure.StrokeKingRule;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestStrokeKingRule {

    @Test
    public void testA1A2(){

        StrokeFigureRule strokeFigureRule = new StrokeKingRule();

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

        StrokeFigureRule strokeFigureRule = new StrokeKingRule();

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
    public void testA1B2(){

        StrokeFigureRule strokeFigureRule = new StrokeKingRule();

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
    public void testC3B3(){

        StrokeFigureRule strokeFigureRule = new StrokeKingRule();

        Stroke stroke = null;
        try {
            stroke = new Stroke("c3 b3");
        } catch (CellCorrectException e) {
            e.printStackTrace();
        } catch (StrokeCorrectException e) {
            e.printStackTrace();
        }
        boolean resultStroke = strokeFigureRule.strokeFigureRule(stroke);

        assertEquals(resultStroke, true);
    }

    @Test
    public void testC3B4(){

        StrokeFigureRule strokeFigureRule = new StrokeKingRule();

        Stroke stroke = null;
        try {
            stroke = new Stroke("c3 b4");
        } catch (CellCorrectException e) {
            e.printStackTrace();
        } catch (StrokeCorrectException e) {
            e.printStackTrace();
        }
        boolean resultStroke = strokeFigureRule.strokeFigureRule(stroke);

        assertEquals(resultStroke, true);
    }

    @Test
    public void testC3C2(){

        StrokeFigureRule strokeFigureRule = new StrokeKingRule();

        Stroke stroke = null;
        try {
            stroke = new Stroke("c3 c2");
        } catch (CellCorrectException e) {
            e.printStackTrace();
        } catch (StrokeCorrectException e) {
            e.printStackTrace();
        }
        boolean resultStroke = strokeFigureRule.strokeFigureRule(stroke);

        assertEquals(resultStroke, true);
    }

    @Test
    public void testC3B2(){

        StrokeFigureRule strokeFigureRule = new StrokeKingRule();

        Stroke stroke = null;
        try {
            stroke = new Stroke("c3 b2");
        } catch (CellCorrectException e) {
            e.printStackTrace();
        } catch (StrokeCorrectException e) {
            e.printStackTrace();
        }
        boolean resultStroke = strokeFigureRule.strokeFigureRule(stroke);

        assertEquals(resultStroke, true);
    }

    @Test
    public void testC3D2(){

        StrokeFigureRule strokeFigureRule = new StrokeKingRule();

        Stroke stroke = null;
        try {
            stroke = new Stroke("c3 d2");
        } catch (CellCorrectException e) {
            e.printStackTrace();
        } catch (StrokeCorrectException e) {
            e.printStackTrace();
        }
        boolean resultStroke = strokeFigureRule.strokeFigureRule(stroke);

        assertEquals(resultStroke, true);
    }

    @Test
    public void testA1A3(){

        StrokeFigureRule strokeFigureRule = new StrokeKingRule();

        Stroke stroke = null;
        try {
            stroke = new Stroke("a1 a3");
        } catch (CellCorrectException e) {
            e.printStackTrace();
        } catch (StrokeCorrectException e) {
            e.printStackTrace();
        }
        boolean resultStroke = strokeFigureRule.strokeFigureRule(stroke);

        assertEquals(resultStroke, false);
    }

}
