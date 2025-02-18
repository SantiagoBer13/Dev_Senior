package com.code;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LoggerExample {
    private static final Logger logger = LogManager.getLogger(LoggerExample.class);
    public static void main(String[] args) {
        logger.debug("Starting the application...");
        logger.info("Starting the application...");
        logger.warn("Processing the application...");
        logger.error("An error has occurred!");
        logger.fatal("An error has occurred!");
    }
}