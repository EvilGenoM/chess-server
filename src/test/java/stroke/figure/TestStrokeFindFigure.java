package stroke.figure;

import mobi.mpk.chess.domain.Board;
import mobi.mpk.chess.domain.Cell;
import mobi.mpk.chess.domain.Color;
import mobi.mpk.chess.domain.Stroke;
import mobi.mpk.chess.domain.exception.CellCorrectException;
import mobi.mpk.chess.domain.exception.FigureNotFindException;
import mobi.mpk.chess.domain.exception.StrokeCorrectException;
import mobi.mpk.chess.domain.figure.Pawn;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestStrokeFindFigure {

    private Board board;

    @Before
    public void before(){
        try {
            board = new Board();

            Cell cell = new Cell('a', 1);
            cell = board.getCell(cell);

            cell.setFigure(new Pawn(Color.white));
        } catch (CellCorrectException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testExistFigure(){

        try {
            Stroke stroke = new Stroke("a1 a2");
            stroke.findFigure(board);

            String figureName = stroke.getFigure().getClass().getSimpleName();

            assertEquals(figureName, "Pawn");

        } catch (CellCorrectException e) {
            e.printStackTrace();
        } catch (StrokeCorrectException e) {
            e.printStackTrace();
        } catch (FigureNotFindException e) {
            e.printStackTrace();
        }

    }

    @Test(expected = FigureNotFindException.class)
    public void testNullFigure() throws StrokeCorrectException, CellCorrectException, FigureNotFindException {

        Stroke stroke = new Stroke("a2 a3");
        stroke.findFigure(board);

    }

}
