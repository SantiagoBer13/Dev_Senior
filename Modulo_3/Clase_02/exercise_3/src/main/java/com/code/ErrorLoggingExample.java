package com.code;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ErrorLoggingExample {
    private static final Logger logger = LoggerFactory.getLogger(ErrorLoggingExample.class);
    public static void main(String[] args) throws ZeroDivisionException {
        System.out.println("--- Generate Exception ---");
        int a = 20, b = 0;
        try {
            logger.debug("Dividing {} by {}", a, b);
            double result = divide(a, b);
            logger.debug("Result: {}", result);
        } catch (ZeroDivisionException e) {
            logger.error("Error: {}", e.getMessage());
        }
        logger.info("End of program");
    }

    public static double divide(int a, int b) throws ZeroDivisionException {
        if (b == 0) {
            throw new ZeroDivisionException("Can't divide by zero");
        }
        return (double) a / b;
    }
}