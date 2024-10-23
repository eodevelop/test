package test.app.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class KubeCheckController {

    @GetMapping("/api/healthcheck")
    public String healthCheck() {
        return "OK";
    }

    @GetMapping("/api/readycheck")
    public String readyCheck() {
        return "OK";
    }
}
