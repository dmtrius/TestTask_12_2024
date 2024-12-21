package pl.dmt.services;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import pl.dmt.loggers.Logger;

import java.util.Objects;

@Service
public class LogService {
    private final Logger logger;

    public LogService(Logger logger) {
        this.logger = logger;
    }

    public void log(String message) {
        if (Objects.isNull(message) || StringUtils.isEmpty(message)) {
            throw new IllegalArgumentException("Invalid message: " + message);
        }
        logger.log(message);
    }
}
