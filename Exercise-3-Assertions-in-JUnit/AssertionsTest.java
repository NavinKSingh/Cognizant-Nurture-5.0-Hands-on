import org.junit.Test;
import org.junit.Before;
import static org.junit.Assert.*;

public class AssertionsTest {

    private MathUtils math;

    @Before
    public void setUp() {
        math = new MathUtils();
    }

    // 1. assertEquals - expected == actual?
    @Test
    public void testAssertEquals() {
        assertEquals(5, math.add(2, 3));
        System.out.println("assertEquals passed!");
    }

    // 2. assertTrue - condition true hai?
    @Test
    public void testAssertTrue() {
        assertTrue(math.isPositive(10));
        System.out.println("assertTrue passed!");
    }

    // 3. assertFalse - condition false hai?
    @Test
    public void testAssertFalse() {
        assertFalse(math.isNegative(10));
        System.out.println("assertFalse passed!");
    }

    // 4. assertNull - value null hai?
    @Test
    public void testAssertNull() {
        assertNull(math.getValue(0));
        System.out.println("assertNull passed!");
    }

    // 5. assertNotNull - value null nahi hai?
    @Test
    public void testAssertNotNull() {
        assertNotNull(math.createObject());
        System.out.println("assertNotNull passed!");
    }

    // 6. BONUS: assertArrayEquals - dono arrays equal hain?
    @Test
    public void testAssertArrayEquals() {
        int[] expected = {1, 2, 3};
        int[] actual   = {1, 2, 3};
        assertArrayEquals(expected, actual);
        System.out.println("assertArrayEquals passed!");
    }
}