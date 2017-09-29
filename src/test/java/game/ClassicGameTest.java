package game;

import mobi.mpk.chess.User;
import mobi.mpk.chess.domain.Color;
import mobi.mpk.chess.domain.Player;
import mobi.mpk.chess.domain.ResultStroke;
import mobi.mpk.chess.domain.game.ClassicGame;
import mobi.mpk.chess.domain.game.Game;
import mobi.mpk.chess.domain.rules.ClassicInspectorRules;
import mobi.mpk.chess.domain.rules.InspectorRules;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ClassicGameTest {

    private Game game;
    private Player playerWhite;
    private Player playerBlack;

    @Before
    public void before(){

        playerWhite = new Player(new User("PlayerWhite"));
        playerBlack = new Player(new User("PlayerBlack"));

        InspectorRules inspector = new ClassicInspectorRules();
        game = new ClassicGame(playerWhite, playerBlack, inspector);

        playerBlack.setColorFigures(Color.black);
        playerWhite.setColorFigures(Color.white);

    }

    @Test
    public void testA2A4(){

        ResultStroke resultStroke = game.doStroke(playerWhite, "a2 a4");

        assert(resultStroke.isSuccess());

    }

    @Test
    public void testB2A3(){

        ResultStroke resultStroke = game.doStroke(playerWhite, "b2 a3");

        assertEquals(resultStroke.isSuccess(), false);
    }

    @Test
    public void testB2B4(){

        ResultStroke resultStroke = game.doStroke(playerWhite, "b2 b4");

        assertEquals(resultStroke.isSuccess(), true);
    }

    @Test
    public void testC2C3(){

        game.doStroke(playerWhite, "c2 c3");
        ResultStroke resultStroke = game.doStroke(playerWhite, "d2 d3");

        assertEquals(resultStroke.isSuccess(), false);
    }

    @Test
    public void testD7D5(){

        game.doStroke(playerWhite, "d2 d3");
        ResultStroke resultStroke = game.doStroke(playerBlack, "d7 d5");

        assertEquals(resultStroke.isSuccess(), true);
    }

}
