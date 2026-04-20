package com.example.fargate.planning;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.health.contributor.Health;
import org.springframework.boot.health.contributor.HealthIndicator;
import org.springframework.stereotype.Component;

@Component
public class AppControllerTestHealthIndicator implements HealthIndicator {

    @Value("${app.fail:false}")
    private boolean fail;

    @Override
    public Health health() {
        if (fail) {
            return Health.down()
                    .withDetail("reason", "Simulated failure")
                    .build();
        }
        return Health.up().build();
    }
}