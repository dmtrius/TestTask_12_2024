package pl.dmt.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.dmt.services.LogService;

@RequestMapping("/api/${app.services.version}")
@RestController
public class LogController {
    private final LogService service;

    public LogController(LogService service) {
        this.service = service;
    }

    @PostMapping("/log")
    public ResponseEntity<Void> Log(@RequestBody(required = false) String message) {
        service.logMessage(message);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
