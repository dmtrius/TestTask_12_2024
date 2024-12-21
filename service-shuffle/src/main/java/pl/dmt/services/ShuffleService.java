package pl.dmt.services;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Service
public class ShuffleService {
    @Value("${app.min-num}")
    private int MIN_NUM;
    @Value("${app.max-num}")
    private int MAX_NUM;

    private final LogService logService;

    public ShuffleService(LogService logService) {
        this.logService = logService;
    }

    public int[] getShuffledArray(int n) {
        if (n < MIN_NUM || n > MAX_NUM) {
            throw new IllegalArgumentException(
                    "Number must be greater than %d and less than %d"
                            .formatted(MIN_NUM, MAX_NUM));
        }
        List<Integer> list = IntStream.rangeClosed(1, n)
                .boxed()
                .collect(Collectors.toList());
        Collections.shuffle(list, new Random());
        int[] result = list.stream().mapToInt(Integer::intValue).toArray();

        logService.logMessage(Arrays.toString(result));

        return result;
    }
}
