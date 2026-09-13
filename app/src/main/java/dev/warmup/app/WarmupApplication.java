package dev.warmup.app;

import dev.warmup.core.Calculator;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class WarmupApplication {
    public static void main(String[] args) {
        SpringApplication.run(WarmupApplication.class, args);
    }

    @Bean
    Calculator calculator() {
        return new Calculator();
    }
}
