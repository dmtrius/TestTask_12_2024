package pl.dmt.kafka;

import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import pl.dmt.loggers.Logger;

@Service
@Slf4j
public class KafkaConsumer {
    private final Logger logger;

    public KafkaConsumer(Logger logger) {
        this.logger = logger;
    }

    @KafkaListener(topics = "${spring.kafka.consumer.topic}",
            groupId = "${spring.kafka.consumer.group-id}")
    public void listen(String message) {
        logger.log(message);
    }
}
