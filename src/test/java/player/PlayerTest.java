package player;

import mobi.mpk.chess.User;
import mobi.mpk.chess.domain.*;
import mobi.mpk.chess.domain.exception.CellCorrectException;
import mobi.mpk.chess.domain.exception.FigureNotFindException;
import mobi.mpk.chess.domain.exception.StrokeCorrectException;
import mobi.mpk.chess.domain.figure.Rook;
import mobi.mpk.chess.domain.rules.ClassicInspectorRules;
import mobi.mpk.chess.domain.rules.InspectorRules;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PlayerTest {

    private Board board;

    @Before
    public void before(){

        try {
            board = new Board();

            Cell cell = new Cell('a', 1);
            cell = board.getCell(cell);

            cell.setFigure(new Rook(Color.white));
        } catch (CellCorrectException e) {
            e.printStackTrace();
        }

    }

    @Test
    public void testA1A3() throws Exception {

        User user = new User("Player");

        Player player = new Player(user);
        player.setColorFigures(Color.white);

        InspectorRules inspector = new ClassicInspectorRules();

        Stroke stroke = new Stroke("a1 a3");
        stroke.findFigure(board);

        player.move(stroke, board, inspector);

        Cell cell = new Cell('a', 1);
        cell = board.getCell(cell);
        assertEquals(cell.getFigure(), null);

        cell = new Cell('a', 3);
        cell = board.getCell(cell);
        assertEquals(cell.getFigure(), new Rook());



    }

}
