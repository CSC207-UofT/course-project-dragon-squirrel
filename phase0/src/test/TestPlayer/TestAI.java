package TestPlayer;

import Player.AI;
import org.junit.Before;

import static org.junit.Assert.assertEquals;

public class TestAI {
    AI ai;

    @Before
    public void setup(){
        ai = new AI("Computer Player.Player");
    }

}
