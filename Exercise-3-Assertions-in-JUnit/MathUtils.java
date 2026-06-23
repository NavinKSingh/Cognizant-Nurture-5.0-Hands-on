public class MathUtils {

    // Addition
    public int add(int a, int b) {
        return a + b;
    }

    // Check if number is positive
    public boolean isPositive(int n) {
        return n > 0;
    }

    // Check if number is negative
    public boolean isNegative(int n) {
        return n < 0;
    }

    // Returns null if input is 0, else returns the number
    public Integer getValue(int n) {
        if (n == 0) return null;
        return n;
    }

    // Creates and returns a new object
    public Object createObject() {
        return new Object();
    }
}