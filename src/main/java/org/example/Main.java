package org.example;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Main {
    private static Logger logger = LoggerFactory.getLogger(Main.class);
    public static void main(String[] args) {
        logger.info("Starting application");
        if (args.length == 0) {
            logger.info("No arguments");
        } else {
            logger.info("Arguments:");
            try {
                retrieveCouses(args);
            } catch (Exception e) {
                logger.info("Error: " + e.getMessage());
            }
        }
    }

    private static void retrieveCouses(String[] args) {
        for (String arg : args) {
            logger.info("arg: " + arg);
        }
    }
}