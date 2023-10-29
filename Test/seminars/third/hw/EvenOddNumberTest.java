package seminars.third.hw;

import org.junit.BeforeClass;
import org.junit.AfterClass;
import org.junit.Test;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class EvenOddNumberTest {
    private static MainHW mainHW;

    @BeforeClass
    public static void setUp() {
        mainHW = new MainHW();
    }

    @AfterClass
    public static void tearDown() {
    }

    @Test
    public void testEvenNumber() {
        assertTrue(mainHW.evenOddNumber(4));
    }

    @Test
    public void testOddNumber() {
        assertFalse(mainHW.evenOddNumber(7));
    }

    @Test
    public void testZeroIsEven() {
        assertTrue(mainHW.evenOddNumber(0));
    }

    @Test
    public void testNegativeEvenNumber() {
        assertTrue(mainHW.evenOddNumber(-2));
    }

    @Test
    public void testNegativeOddNumber() {
        assertFalse(mainHW.evenOddNumber(-3));
    }
}


