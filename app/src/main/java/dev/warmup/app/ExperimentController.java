package dev.warmup.app;

import dev.warmup.core.Calculator;
import java.util.List;
import java.util.Map;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/experiments")
public class ExperimentController {
    private final Calculator calculator;
    private final ExperimentRepository repository;

    public ExperimentController(Calculator calculator, ExperimentRepository repository) {
        this.calculator = calculator;
        this.repository = repository;
    }

    @GetMapping("/cpu")
    Map<String, Object> cpu() {
        return Map.of("result", calculator.calculate(100_000));
    }

    @GetMapping("/serialization")
    ExperimentResponse serialization() {
        return new ExperimentResponse(1L, "warmup", List.of("JVM", "Spring", "JIT"));
    }

    @GetMapping("/database")
    List<ExperimentRecord> database() {
        if (repository.count() == 0) repository.save(new ExperimentRecord("first-query"));
        return repository.findAll();
    }

    @GetMapping("/mixed")
    Map<String, Object> mixed() {
        return Map.of("calculation", calculator.calculate(100_000), "records", database());
    }

    record ExperimentResponse(long id, String name, List<String> tags) {}
}
