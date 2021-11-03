import org.junit.Before;
import player.Human;

import static org.junit.Assert.assertEquals;

public class TestHuman {
    Human h;

    @Before
    public void setup(){
        h = new Human("player.Human player.Player");
    }

}
