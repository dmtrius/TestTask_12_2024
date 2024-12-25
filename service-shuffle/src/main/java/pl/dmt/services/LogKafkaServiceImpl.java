package pl.dmt.services;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import pl.dmt.kafka.LogKafkaProducer;

@Profile("kafka")
@Service("logKafkaService")
public class LogKafkaServiceImpl implements LogService {
    @Value("${spring.kafka.consumer.key}")
    private String key;
    @Value("${spring.kafka.consumer.topic}")
    private String topic;

    private final LogKafkaProducer producer;

    public LogKafkaServiceImpl(LogKafkaProducer producer) {
        this.producer = producer;
    }

    @Override
    public void logMessage(String message) {
        producer.sendMessage(topic, key, message);
    }
}
