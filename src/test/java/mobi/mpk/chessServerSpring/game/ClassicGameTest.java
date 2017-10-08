package mobi.mpk.chessServerSpring.game;


import mobi.mpk.chessServerSpring.User;
import mobi.mpk.chessServerSpring.domain.Color;
import mobi.mpk.chessServerSpring.domain.Player;
import mobi.mpk.chessServerSpring.domain.ResultStroke;
import mobi.mpk.chessServerSpring.domain.game.ClassicGame;
import mobi.mpk.chessServerSpring.domain.game.Game;
import mobi.mpk.chessServerSpring.domain.rules.ClassicInspectorRules;
import mobi.mpk.chessServerSpring.domain.rules.InspectorRules;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ClassicGameTest {

    private Game game;
    private User playerWhite;
    private User playerBlack;

    @Before
    public void before(){

        playerWhite = new User("PlayerWhite");
        playerBlack = new User("PlayerBlack");

        InspectorRules inspector = new ClassicInspectorRules();
        game = new ClassicGame(playerWhite, playerBlack, inspector);

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
