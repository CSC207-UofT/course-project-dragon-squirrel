import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestAI {
    AI ai1;
    AI ai2;

    @Before
    public void setUp(){
        ai1 = new AI();
        ai2 = new AI("ai2");
    }

//    @Test(timeout = 50)
//    public void testAIConstructor1(){
//        assertEquals(ai1.getID(), "asdf");    // replace "asdf" with default ID once implemented
//    }

    @Test(timeout = 50)
    public void testAIConstructor2(){
        assertEquals(ai2.getID(), "ai2");
    }
}