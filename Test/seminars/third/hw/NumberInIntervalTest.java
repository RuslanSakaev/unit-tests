package seminars.third.hw;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class NumberInIntervalTest {
    @Test
    public void testNumberInInterval() {
        MainHW mainHW = new MainHW();
        assertTrue(mainHW.numberInInterval(50));
    }

    @Test
    public void testNumberBelowInterval() {
        MainHW mainHW = new MainHW();
        assertFalse(mainHW.numberInInterval(20));
    }

    @Test
    public void testNumberAboveInterval() {
        MainHW mainHW = new MainHW();
        assertFalse(mainHW.numberInInterval(110));
    }

    @Test
    public void testLowerBound() {
        MainHW mainHW = new MainHW();
        assertFalse(mainHW.numberInInterval(25));
    }

    @Test
    public void testUpperBound() {
        MainHW mainHW = new MainHW();
        assertFalse(mainHW.numberInInterval(100));
    }
}

