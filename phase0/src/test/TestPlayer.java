import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PlayerTest {
    Player p1;
    Player p2;
    Player p3;
    Player p4;

    @Before
    public void setup(){
        p1 = new Player("player_1");
        p2 = new Player("player_2");
        p3 = new Plyaer("player_3");
        p4 = new Player("player_4");
    }

}