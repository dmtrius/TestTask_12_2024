package pl.dmt.services;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import pl.dmt.dao.ShuffledData;
import reactor.core.publisher.Mono;

import java.util.Arrays;

@Profile("kafka")
@Service("shuffleKafkaService")
public class ShuffleKafkaServiceImpl implements ShuffleService {

    private final ShuffledData data;
    private final LogService logService;

    public ShuffleKafkaServiceImpl(@Qualifier("logKafkaService") LogService logService,
                                   ShuffledData data) {
        this.logService = logService;
        this.data = data;
    }

    @Override
    public int[] getShuffledArray(int n) {
        var result = data.getData(n);
        logService.logMessage(Arrays.toString(result));
        return result;
    }

    @Override
    public Mono<int[]> getShuffleArrayAsync(int n) {
        return Mono.just(getShuffledArray(n));
    }
}
