package rules;

import mobi.mpk.chess.domain.Board;
import mobi.mpk.chess.domain.Cell;
import mobi.mpk.chess.domain.Color;
import mobi.mpk.chess.domain.Stroke;
import mobi.mpk.chess.domain.exception.CellCorrectException;
import mobi.mpk.chess.domain.exception.FigureNotFindException;
import mobi.mpk.chess.domain.exception.rule.FigureCanNotMoveException;
import mobi.mpk.chess.domain.exception.rule.PossibleMoveException;
import mobi.mpk.chess.domain.exception.rule.WayFigureHaveObstaclesException;
import mobi.mpk.chess.domain.figure.Rook;
import mobi.mpk.chess.domain.rules.ClassicInspectorRules;
import mobi.mpk.chess.domain.rules.InspectorRules;
import org.junit.Before;
import org.junit.Test;

public class ClassicInspectorRulesTest {

    private Board board;

    @Before
    public void before(){

        try {
            board = new Board();

            Cell cell = new Cell('a', 1);
            cell = board.getCell(cell);

            cell.setFigure(new Rook(Color.white));

            cell = new Cell('a', 8);
            cell = board.getCell(cell);

            cell.setFigure(new Rook(Color.black));

            cell = new Cell('h', 1);
            cell = board.getCell(cell);

            cell.setFigure(new Rook(Color.white));


        } catch (CellCorrectException e) {
            e.printStackTrace();
        }

    }

    @Test(expected = PossibleMoveException.class)
    public void testA1A8() throws Exception {

        Stroke stroke = new Stroke("a1 a8");
        stroke.findFigure(board);
        InspectorRules inspector = new ClassicInspectorRules();
        inspector.checkMoveRules(board, stroke, Color.black);
    }

    @Test(expected = WayFigureHaveObstaclesException.class)
    public void testA1H1() throws Exception {

        Stroke stroke = new Stroke("a1 h1");
        stroke.findFigure(board);
        InspectorRules inspector = new ClassicInspectorRules();
        inspector.checkMoveRules(board, stroke, Color.white);

        assert(false);
    }

    @Test(expected = FigureCanNotMoveException.class)
    public void testA1C3() throws Exception {

        Stroke stroke = new Stroke("a1 c3");
        stroke.findFigure(board);
        InspectorRules inspector = new ClassicInspectorRules();
        inspector.checkMoveRules(board, stroke, Color.white);

    }

    @Test(expected = FigureNotFindException.class)
    public void testC3C4() throws Exception {

        Stroke stroke = new Stroke("c3 a4");
        stroke.findFigure(board);
        InspectorRules inspector = new ClassicInspectorRules();
        inspector.checkMoveRules(board, stroke, Color.white);

    }

    @Test
    public void testA1A8true() throws Exception {

        Stroke stroke = new Stroke("a1 a8");
        stroke.findFigure(board);
        InspectorRules inspector = new ClassicInspectorRules();
        inspector.checkMoveRules(board, stroke, Color.white);

        assert(true);

    }




}
