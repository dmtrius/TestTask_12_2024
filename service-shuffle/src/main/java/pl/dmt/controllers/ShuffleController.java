package pl.dmt.controllers;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.dmt.services.ShuffleService;

@RequestMapping("/api")
@RestController
public class ShuffleController {
    private final ShuffleService service;

    public ShuffleController(ShuffleService service) {
        this.service = service;
    }

    @PostMapping("/shuffle/{n}")
    public int[] shuffleArray(@PathVariable int n) {
        return service.getShuffledArray(n);
    }

}
