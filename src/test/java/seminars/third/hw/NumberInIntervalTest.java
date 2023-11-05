package seminars.third.hw;

import org.example.seminars.third.hw.MainHW;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class NumberInIntervalTest {
    private MainHW mainHW;

    @Before
    public void setUp() {
        mainHW = new MainHW();
    }

    @After
    public void tearDown() {
    }

    @Test
    public void testNumberInInterval() {
        assertTrue(mainHW.numberInInterval(50));
    }

    @Test
    public void testNumberBelowInterval() {
        assertFalse(mainHW.numberInInterval(20));
    }

    @Test
    public void testNumberAboveInterval() {
        assertFalse(mainHW.numberInInterval(110));
    }

    @Test
    public void testLowerBound() {
        assertFalse(mainHW.numberInInterval(25));
    }

    @Test
    public void testUpperBound() {
        assertFalse(mainHW.numberInInterval(100));
    }
}


