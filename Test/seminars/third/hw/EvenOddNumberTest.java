package seminars.third.hw;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class EvenOddNumberTest {
    @Test
    public void testEvenNumber() {
        MainHW mainHW = new MainHW();
        assertTrue(mainHW.evenOddNumber(4));
    }

    @Test
    public void testOddNumber() {
        MainHW mainHW = new MainHW();
        assertFalse(mainHW.evenOddNumber(7));
    }

    @Test
    public void testZeroIsEven() {
        MainHW mainHW = new MainHW();
        assertTrue(mainHW.evenOddNumber(0));
    }

    @Test
    public void testNegativeEvenNumber() {
        MainHW mainHW = new MainHW();
        assertTrue(mainHW.evenOddNumber(-2));
    }

    @Test
    public void testNegativeOddNumber() {
        MainHW mainHW = new MainHW();
        assertFalse(mainHW.evenOddNumber(-3));
    }
}

