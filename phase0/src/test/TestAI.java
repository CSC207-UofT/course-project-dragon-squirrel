import org.junit.Before;
import org.junit.Test;
import player.AI;

import static org.junit.Assert.assertEquals;

public class TestAI {
    AI ai;

    @Before
    public void setup(){
        ai = new AI("Computer player.Player");
    }

}
