package TestPlayer;

import Player.Player;
import org.junit.Before;
import org.junit.Test;
import piece.Color;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class TestPlayer {

    Player p;

    @Before
    public void setup(){
        p = new Player("player");
    }

    @Test(timeout = 50)
    public void TestgetID(){
        assertEquals("player", p.getID());
    }

    @Test(timeout = 50)
    public void TestsetColor(){
        assertEquals(null, p.getColor());
        p.setColor(Color.WHITE);
        assertEquals(Color.WHITE, p.getColor());
    }

    @Test(timeout = 50)
    public void TestgetColor(){
        p.setColor(Color.BLACK);
        assertEquals(Color.BLACK, p.getColor());
    }

    @Test(timeout = 50)
    public void TestsetStatus(){
        assertEquals(false, p.getStatus());
        p.setStatus(true);
        assertTrue(p.getStatus());
    }

    @Test(timeout = 50)
    public void TestgetStatus(){
        p.setStatus(true);
        assertTrue(p.getStatus());
    }

}
