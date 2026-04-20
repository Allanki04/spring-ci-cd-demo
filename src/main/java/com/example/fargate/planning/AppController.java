package com.example.fargate.planning;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/App")
public class AppController {

    @Value("${app.delay:0}")
    private int delay;

    @GetMapping("/work")
    public String work() throws InterruptedException {
        if (delay > 0) Thread.sleep(delay);
        return "working priya";
    }
}
