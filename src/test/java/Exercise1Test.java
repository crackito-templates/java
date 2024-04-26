import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import io.crackito.EmptyStackException;
import io.crackito.PileBornee;
import org.junit.Test;

public class Exercise1Test {

    @Test
    public void testIsEmptyAfterCreate() {
        PileBornee p = new PileBornee(3);
        assertTrue(p.isEmpty());
    }

    @Test
    public void testIsEmptyAfterCreateAndPush() {
        PileBornee p = new PileBornee(3);
        p.push(20);
        assertFalse(p.isEmpty());
    }

    @Test
    public void testMaxSizeAfterCreate() {
        PileBornee p = new PileBornee(3);
        assertEquals(3, p.getMaxSize());
    }

    @Test
    public void testMaxSizeAfterCreateAndPush() {
        PileBornee p = new PileBornee(3);
        p.push(20);
        assertEquals(3, p.getMaxSize());
    }

    @Test
    public void testGetSizeAfterCreate() {
        PileBornee p = new PileBornee(2);
        assertEquals(0, p.getSize());
    }

    @Test
    public void testGetSizeAfterCreateAndPush() {
        PileBornee p = new PileBornee(2);
        p.push(11);
        assertEquals(1, p.getSize());

        p.push(22);
        assertEquals(2, p.getSize());

        p.push(33);
        assertEquals(2, p.getSize());
    }

    @Test
    public void testIsNotFullAfterCreate() {
        PileBornee p = new PileBornee(2);
        assertFalse(p.isFull());
    }

    @Test
    public void testIsFullAfterCreateAndPush() {
        PileBornee p = new PileBornee(2);
        p.push(11);
        assertFalse(p.isFull());

        p.push(22);
        assertTrue(p.isFull());
    }

    @Test
    public void testTopAfterCreateAndPush() throws EmptyStackException {
        PileBornee p = new PileBornee(2);
        p.push(11);
        assertEquals(11, p.top());

        p.push(22);
        assertEquals(22, p.top());

        p.push(33);
        assertEquals(22, p.top());
    }

    @Test
    public void testPopAfterCreate() {
        PileBornee p = new PileBornee(2);
        p.pop();
        assertEquals(2, p.getMaxSize());
        assertEquals(0, p.getSize());
    }

    @Test
    public void testPopAfterCreateandPush() throws EmptyStackException {
        PileBornee p = new PileBornee(2);
        p.push(11);
        p.pop();
        assertTrue(p.isEmpty());

        p.push(11);
        p.push(22);
        p.pop();
        assertEquals(11, p.top());
    }

    @Test(expected = EmptyStackException.class)
    public void testTopAfterCreate() throws EmptyStackException {
        PileBornee p = new PileBornee(2);
        p.top();
    }

    @Test(expected = IllegalArgumentException.class)
    public void TestProblemMaxSizeAfterCreateValeurNulle() {
        PileBornee p = new PileBornee(0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void TestProblemMaxSizeAfterCreateValeurNegative() {
        PileBornee p = new PileBornee(-1);
    }

}
