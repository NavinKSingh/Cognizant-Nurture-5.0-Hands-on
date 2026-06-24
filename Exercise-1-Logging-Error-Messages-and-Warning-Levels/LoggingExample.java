import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LoggingExample {

    private static final Logger logger = LoggerFactory.getLogger(LoggingExample.class);

    public static void main(String[] args) {

        // 1. TRACE - finest level of detail
        logger.trace("TRACE: Application is starting...");

        // 2. DEBUG - useful during development
        logger.debug("DEBUG: Variable x = {}", 42);

        // 3. INFO - general information
        logger.info("INFO: Application started successfully!");

        // 4. WARN - something might go wrong
        logger.warn("WARN: Memory usage is at 80%!");

        // 5. ERROR - something went wrong
        logger.error("ERROR: Database connection failed!");

        // Real world example - logging with exception
        try {
            int result = 10 / 0;
        } catch (ArithmeticException e) {
            logger.error("ERROR: Division by zero occurred! Reason: {}", e.getMessage());
        }

        // Using placeholders {}
        String user = "Navin";
        int age = 21;
        logger.info("User {} is {} years old", user, age);

        logger.info("Application is shutting down. Goodbye!");
    }
}