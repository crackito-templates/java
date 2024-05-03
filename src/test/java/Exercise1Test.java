import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import io.crackito.Duration;

public class Exercise1Test {

    @Test
    public void testGetters() {
        Duration d = new Duration(1, 2, 3);
        assertEquals(1, d.getHour());
        assertEquals(2, d.getMinute());
        assertEquals(3, d.getSecond());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testNegativeHour() {
        new Duration(-1, 2, 3);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testNegativeMinute() {
        new Duration(1, -2, 3);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testNegativeSecond() {
        new Duration(1, 2, -3);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testMinuteGreatherThan59() {
        new Duration(1, 60, 3);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSecondGreatherThan59() {
        new Duration(1, 2, 60);
    }

    @Test
    public void testEqual() {
        assertTrue(new Duration(1, 2, 3).equal(new Duration(1, 2, 3)));
    }

    @Test
    public void testNonEqual() {
        assertFalse(new Duration(1, 2, 3).equal(new Duration(2, 2, 3)));
        assertFalse(new Duration(1, 2, 3).equal(new Duration(1, 1, 3)));
        assertFalse(new Duration(1, 2, 3).equal(new Duration(1, 2, 2)));
    }

    @Test
    public void testAddOneSecond() {
        Duration d123 = new Duration(1, 2, 3);
        d123 = d123.addOneSeconde();
        assertTrue(new Duration(1, 2, 4).equal(d123));
        Duration d1259 = new Duration(1, 2, 59);
        d1259=  d1259.addOneSeconde();
        assertTrue(new Duration(1, 3, 0).equal(d1259));
        Duration d5959 = new Duration(1, 59, 59);
        d5959= d5959.addOneSeconde();
        assertTrue(new Duration(2, 0, 0).equal(d5959));
    }

    @Test
    public void testLower() {
        assertTrue(new Duration(1, 2, 3).lower(new Duration(2, 2, 3)));
        assertTrue(new Duration(1, 2, 3).lower(new Duration(1, 3, 3)));
        assertTrue(new Duration(1, 2, 3).lower(new Duration(1, 2, 4)));
    }

    @Test
    public void testNonLower() {
        assertFalse(new Duration(1, 2, 3).lower(new Duration(1, 2, 3)));
        assertFalse(new Duration(1, 3, 3).lower(new Duration(1, 2, 3)));
        assertFalse(new Duration(1, 2, 4).lower(new Duration(1, 2, 3)));
    }

    @Test
    public void testToString() {
        assertEquals("1:2:3", new Duration(1, 2, 3).toString());
    }
}
