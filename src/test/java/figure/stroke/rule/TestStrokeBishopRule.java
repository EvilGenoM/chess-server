package figure.stroke.rule;

import mobi.mpk.chess.domain.Stroke;
import mobi.mpk.chess.domain.exception.CellCorrectException;
import mobi.mpk.chess.domain.exception.StrokeCorrectException;
import mobi.mpk.chess.domain.rules.rule.stoke.figure.StrokeBishopRule;
import mobi.mpk.chess.domain.rules.rule.stoke.figure.StrokeFigureRule;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestStrokeBishopRule {

    @Test
    public void testA1B2(){

        StrokeFigureRule strokeFigureRule = new StrokeBishopRule();

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
    public void testA1H8(){

        StrokeFigureRule strokeFigureRule = new StrokeBishopRule();

        Stroke stroke = null;
        try {
            stroke = new Stroke("a1 h8");
        } catch (CellCorrectException e) {
            e.printStackTrace();
        } catch (StrokeCorrectException e) {
            e.printStackTrace();
        }
        boolean resultStroke = strokeFigureRule.strokeFigureRule(stroke);

        assertEquals(resultStroke, true);

    }

    @Test
    public void testH8A1(){

        StrokeFigureRule strokeFigureRule = new StrokeBishopRule();

        Stroke stroke = null;
        try {
            stroke = new Stroke("h8 a1");
        } catch (CellCorrectException e) {
            e.printStackTrace();
        } catch (StrokeCorrectException e) {
            e.printStackTrace();
        }
        boolean resultStroke = strokeFigureRule.strokeFigureRule(stroke);

        assertEquals(resultStroke, true);

    }

    @Test
    public void testA8H1(){

        StrokeFigureRule strokeFigureRule = new StrokeBishopRule();

        Stroke stroke = null;
        try {
            stroke = new Stroke("a8 h1");
        } catch (CellCorrectException e) {
            e.printStackTrace();
        } catch (StrokeCorrectException e) {
            e.printStackTrace();
        }
        boolean resultStroke = strokeFigureRule.strokeFigureRule(stroke);

        assertEquals(resultStroke, true);

    }

    @Test
    public void testA1A8(){

        StrokeFigureRule strokeFigureRule = new StrokeBishopRule();

        Stroke stroke = null;
        try {
            stroke = new Stroke("a1 a8");
        } catch (CellCorrectException e) {
            e.printStackTrace();
        } catch (StrokeCorrectException e) {
            e.printStackTrace();
        }
        boolean resultStroke = strokeFigureRule.strokeFigureRule(stroke);

        assertEquals(resultStroke, false);

    }

}
