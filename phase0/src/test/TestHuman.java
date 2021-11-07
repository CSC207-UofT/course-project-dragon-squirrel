import Player.Human;
import org.junit.Before;

import static org.junit.Assert.assertEquals;

public class TestHuman {
    Human h;

    @Before
    public void setup(){
        h = new Human("Player.Human Player.Player");
    }

}
