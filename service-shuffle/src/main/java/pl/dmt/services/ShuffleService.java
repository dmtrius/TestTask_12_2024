package pl.dmt.services;

import reactor.core.publisher.Mono;

public interface ShuffleService {
    int[] getShuffledArray(int n);
    Mono<int[]> getShuffleArrayAsync(int n);
}
