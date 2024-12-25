package pl.dmt.kafka;

import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service("LogKafkaProducer")
@Slf4j
public class LogKafkaProducer {
    private final KafkaTemplate<String, String> kafkaTemplate;

    public LogKafkaProducer(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendMessage(String topic, String key, String message) {
        kafkaTemplate.send(topic, key, message);
        log.info("LOGGED> message: {} sent to topic: {}", message, topic);
    }
}
