package pl.dmt.loggers;

import org.springframework.stereotype.Component;

@Component
public class ConsoleLogger implements Logger {
    @Override
    public void log(String message) {
        System.out.printf("LOGGED> message: %s%n", message);
    }
}
