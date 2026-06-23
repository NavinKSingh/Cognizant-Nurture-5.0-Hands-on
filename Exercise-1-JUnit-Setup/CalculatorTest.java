import org.junit.Test;
import org.junit.Before;
import static org.junit.Assert.*;

public class CalculatorTest {

    private Calculator calc;

    // Har test se pehle yeh run hoga
    @Before
    public void setUp() {
        calc = new Calculator();
    }

    @Test
    public void testAdd() {
        assertEquals(5, calc.add(2, 3));
    }

    @Test
    public void testMultiply() {
        assertEquals(12, calc.multiply(3, 4));
    }

    @Test
    public void testDivide() {
        assertEquals(2.5, calc.divide(5, 2), 0.001);
    }

    // Negative test — divide by zero
    @Test(expected = ArithmeticException.class)
    public void testDivideByZero() {
        calc.divide(10, 0);
    }
}