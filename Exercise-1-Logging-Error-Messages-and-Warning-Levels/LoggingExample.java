import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LoggingExample {

    private static final Logger logger = LoggerFactory.getLogger(LoggingExample.class);

    public static void main(String[] args) {

        logger.trace("TRACE: Application start ho raha hai...");

        logger.debug("DEBUG: Variable x = {}", 42);

        logger.info("INFO: Application successfully started!");

        logger.warn("WARN: Memory usage 80% ho gayi hai!");

        logger.error("ERROR: Database connection failed!");

        try {
            int result = 10 / 0;
        } catch (ArithmeticException e) {
            logger.error("ERROR: Division by zero hua! Reason: {}", e.getMessage());
        }

        String user = "Navin";
        int age = 21;
        logger.info("User {} ka age {} hai", user, age);

        logger.info("Application band ho raha hai. Bye!");
    }
}