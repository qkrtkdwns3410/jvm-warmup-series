package dev.warmup.app;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class ExperimentRecord {
    @Id @GeneratedValue
    private Long id;
    private String label;

    protected ExperimentRecord() {}
    public ExperimentRecord(String label) { this.label = label; }
    public Long getId() { return id; }
    public String getLabel() { return label; }
}
