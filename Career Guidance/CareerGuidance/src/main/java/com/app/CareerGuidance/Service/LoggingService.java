package com.app.CareerGuidance.Service;

import java.util.logging.Logger;
import org.springframework.stereotype.Service;

@Service
public class LoggingService {
    private static final Logger logger = Logger.getLogger(LoggingService.class.getName());

    public void logAction(String action) {
        logger.info(action);
    }
}
