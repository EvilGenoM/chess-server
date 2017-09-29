package possiblemove;

import mobi.mpk.chess.domain.Board;
import mobi.mpk.chess.domain.Cell;
import mobi.mpk.chess.domain.Color;
import mobi.mpk.chess.domain.Stroke;
import mobi.mpk.chess.domain.exception.CellCorrectException;
import mobi.mpk.chess.domain.exception.FigureNotFindException;
import mobi.mpk.chess.domain.exception.StrokeCorrectException;
import mobi.mpk.chess.domain.figure.Pawn;
import mobi.mpk.chess.domain.rules.rule.possiblemove.ClassicPossibleMoveRule;
import mobi.mpk.chess.domain.rules.rule.possiblemove.PossibleMoveRule;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ClassicPossibleMoveTest {

    private Board board;

    @Before
    public void before(){

        try {
            board = new Board();

            Cell cell = new Cell('a', 1);
            cell = board.getCell(cell);

            cell.setFigure(new Pawn(Color.black));

            cell = new Cell('a', 2);
            cell = board.getCell(cell);

            cell.setFigure(new Pawn(Color.white));
        } catch (CellCorrectException e) {
            e.printStackTrace();
        }

    }

    @Test
    public void testBlackBlack(){

        try {
            Stroke stroke = new Stroke("a1 a2");
            stroke.findFigure(board);

            PossibleMoveRule rule = new ClassicPossibleMoveRule();

            boolean result = rule.checkPossibleMove(Color.black, stroke);
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
    public void testBlackWhite(){

        try {
            Stroke stroke = new Stroke("a1 a2");
            stroke.findFigure(board);

            PossibleMoveRule rule = new ClassicPossibleMoveRule();

            boolean result = rule.checkPossibleMove(Color.white, stroke);
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
    public void testWhiteWhite(){

        try {
            Stroke stroke = new Stroke("a2 a3");
            stroke.findFigure(board);

            PossibleMoveRule rule = new ClassicPossibleMoveRule();

            boolean result = rule.checkPossibleMove(Color.white, stroke);
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
    public void testWhiteBlack(){

        try {
            Stroke stroke = new Stroke("a2 a3");
            stroke.findFigure(board);

            PossibleMoveRule rule = new ClassicPossibleMoveRule();

            boolean result = rule.checkPossibleMove(Color.black, stroke);
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
