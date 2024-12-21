package pl.dmt.services;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import pl.dmt.loggers.Logger;

import java.util.Objects;

@Service
public class LogServiceImpl implements LogService {
    private final Logger logger;

    public LogServiceImpl(Logger logger) {
        this.logger = logger;
    }

    @Override
    public void logMessage(String message) {
        if (Objects.isNull(message)
                || StringUtils.isEmpty(message) || StringUtils.isBlank(message)) {
            throw new IllegalArgumentException("Invalid message: [" + message + "]");
        }
        logger.log(message);
    }
}
